package com.vyng.vertex;

import io.vertx.core.Vertx;

public class HelloWorld {

    public static void main(String[] args) {
        // Create an HTTP server which simply returns "Hello World!" to each request.
        Vertx.vertx()
                .createHttpServer()
                .requestHandler(req -> req.response().end("Hello World!"))
                .listen(5000, handler -> {
                    if (handler.succeeded()) {
                        System.out.println("http://localhost:5000/");
                    } else {
                        System.err.println("Failed to listen on port 5000");
                    }
                });
    }
}
