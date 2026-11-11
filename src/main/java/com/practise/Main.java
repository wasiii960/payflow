package com.practise;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.*;

public class Main {
    private static final String DB_HOST= System.getenv().getOrDefault("DB_HOST", "localhost");
    private static final String DB_PORT = System.getenv().getOrDefault("DB_PORT", "5432");
    private static final String DB_NAME = System.getenv().getOrDefault("DB_NAME", "postgres");
    private static final String DB_USER = System.getenv().getOrDefault("DB_USER", "postgres");
    private static final String DB_PASSWORD = System.getenv().getOrDefault("DB_PASSWORD", "");
    private static final String DB_URL = "jdbc:postgresql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
        String env = System.getenv().getOrDefault("APP_ENV", "dev");

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/health", exchange -> {
            int status;
            String dbStatus;
            String error="";
            try{
                checkDatabase();
                status = 200;
                dbStatus = "UP";
            }catch (Exception e){
                status=503;
                dbStatus = "DOWN";
                error=e.getMessage().replace("\"","'");
            }
            String body = "{\"status\":\"" + (status == 200 ? "UP" : "DOWN") + "\","
                    + "\"env\":\"" + env + "\","
                    + "\"db\":\"" + dbStatus + "\","
                    + "\"error\":\"" + error + "\"}";
            byte[] bytes = body.getBytes(java.nio.charset.StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(status, bytes.length);
            try (var out = exchange.getResponseBody()) {
                out.write(bytes);
            }
        });
        server.start();
        System.out.println("PayFlow listening on port " + port + " (env: " + env + ")");
    }
    private static void checkDatabase() throws SQLException{
        try(Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT 1");
            resultSet.next();
        }
    }
}