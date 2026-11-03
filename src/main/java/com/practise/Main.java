package com.practise;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
        String env = System.getenv().getOrDefault("APP_ENV", "dev");

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/health", exchange -> {
            String body = "{\"status\":\"UP\",\"env\":\"" + env + "\",\"java\":\""
                    + System.getProperty("java.version") + "\"}";
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, body.length());
            try (OutputStream out = exchange.getResponseBody()) {
                out.write(body.getBytes());
            }
        });
        server.start();
        System.out.println("PayFlow listening on port " + port + " (env: " + env + ")");
    }
}