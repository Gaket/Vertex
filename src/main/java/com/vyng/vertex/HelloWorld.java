package com.vyng.vertex;

import io.vertx.core.Vertx;

public class HelloWorld {

    public static void main(String[] args) {
        String host = "0.0.0.0";
        int port = Integer.parseInt(System.getenv("PORT"));
        // Create an HTTP server which simply returns "Hello World!" to each request.
        Vertx.vertx()
                .createHttpServer()
                .requestHandler(req -> req.response().end("Hello World!"))
                .listen(port, handler -> {
                    if (handler.succeeded()) {
                        System.out.println("http://localhost:" + port + "/");
                    } else {
                        System.err.println("Failed to listen on port " + port);
                    }
                });
    }
}
