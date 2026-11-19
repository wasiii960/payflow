package com.practise;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static final String DB_HOST = System.getenv().getOrDefault("DB_HOST", "localhost");
    private static final String DB_PORT = System.getenv().getOrDefault("DB_PORT", "5432");
    private static final String DB_NAME = System.getenv().getOrDefault("DB_NAME", "postgres");
    private static final String DB_USER = System.getenv().getOrDefault("DB_USER", "postgres");
    private static final String DB_PASSWORD = System.getenv().getOrDefault("DB_PASSWORD", "");
    private static final String DB_URL = "jdbc:postgresql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

    private static final JedisPool REDIS =
            new JedisPool(System.getenv().getOrDefault("REDIS_HOST", "localhost"), 6379);
    private static final String RATE_KEY = "rate:PKR";
    private static final int RATE_TTL_SECONDS = 30;

    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
        String env = System.getenv().getOrDefault("APP_ENV", "dev");
        String hostName = System.getenv().getOrDefault("HOSTNAME", "local");

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/health", exchange -> {
            int status;
            String dbStatus;
            String error = "";
            try {
                checkDatabase();
                status = 200;
                dbStatus = "UP";
            } catch (Exception e) {
                status = 503;
                dbStatus = "DOWN";
                error = clean(e.getMessage());
            }
            String body = "{\"status\":\"" + (status == 200 ? "UP" : "DOWN") + "\","
                    + "\"env\":\"" + env + "\","
                    + "\"db\":\"" + dbStatus + "\","
                    + "\"error\":\"" + error + "\","          // FIXED: comma, not a closing brace
                    + "\"host\":\"" + hostName + "\"}";
            sendJson(exchange, status, body);
        });

        server.createContext("/rate", exchange -> {
            int status = 200;
            String error = "";
            String rate = null;
            String source = "cache";
            long startTime = System.currentTimeMillis();

            // 1. Read: try the cache first. If Redis is down, carry on without it.
            try (Jedis jedis = REDIS.getResource()) {
                rate = jedis.get(RATE_KEY);                    // null on a miss
            } catch (JedisException e) {
                System.err.println("Redis unavailable, falling back to database: " + e.getMessage());
            }

            // 2. Miss (or Redis down): read from the database, the source of truth.
            if (rate == null) {
                source = "db";
                try {
                    rate = readRateFromDatabase();
                    // 3. Store it for the next requests. Best effort: a cache failure must not fail the request.
                    try (Jedis jedis = REDIS.getResource()) {
                        jedis.setex(RATE_KEY, RATE_TTL_SECONDS, rate);
                    } catch (JedisException e) {
                        System.err.println("Could not write to Redis: " + e.getMessage());
                    }
                } catch (SQLException e) {
                    status = 503;
                    error = clean(e.getMessage());
                    rate = "";
                }
            }

            long elapsedMs = System.currentTimeMillis() - startTime;
            String body = "{\"status\":\"" + (status == 200 ? "UP" : "DOWN") + "\","
                    + "\"env\":\"" + env + "\","
                    + "\"error\":\"" + error + "\","
                    + "\"rate\":\"" + rate + "\","
                    + "\"source\":\"" + source + "\","
                    + "\"ms\":" + elapsedMs + ","
                    + "\"host\":\"" + hostName + "\"}";
            sendJson(exchange, status, body);
        });

        server.start();
        System.out.println("PayFlow listening on port " + port + " (env: " + env + ")");
    }

    // The slow "database read": a real Postgres query that takes 0.5 seconds.
    private static String readRateFromDatabase() throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT 280.50 AS rate FROM pg_sleep(0.5)")) {
            resultSet.next();
            return resultSet.getString("rate");
        }
    }

    private static void checkDatabase() throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT 1")) {
            resultSet.next();
        }
    }

    private static void sendJson(HttpExchange exchange, int status, String body) throws IOException {
        byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(status, bytes.length);
        try (var out = exchange.getResponseBody()) {
            out.write(bytes);
        }
    }

    // Keeps quotes in error messages from breaking the JSON.
    private static String clean(String message) {
        return message == null ? "" : message.replace("\"", "'");
    }
}
