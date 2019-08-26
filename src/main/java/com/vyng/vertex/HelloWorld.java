package com.vyng.vertex;

import io.vertx.core.Vertx;

public class HelloWorld {

    public static void main(String[] args) {
        int port;
        try {
            port = Integer.parseInt(System.getenv("PORT"));
        } catch (NumberFormatException e) {
            // Port used if Vert.x is started locally
            port = 5000;
        }

        int finalPort = port;

        // Create an HTTP server which simply returns "Hello World!" to each request.
        Vertx.vertx()
                .createHttpServer()
                .requestHandler(req -> req.response().end("Hello World!"))
                .listen(port, handler -> {
                    if (handler.succeeded()) {
                        System.out.println("http://localhost:" + finalPort + "/");
                    } else {
                        System.err.println("Failed to listen on port " + finalPort);
                    }
                });
    }
}
