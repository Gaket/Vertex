package com.vyng.vertex;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class HelloWorldVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        int port = getPort();

        vertx.createHttpServer()
                .requestHandler(req -> req.response().end("Vyng verticle"))
                .listen(port, handler -> {
                    if (handler.succeeded()) {
                        System.out.println("http://localhost:" + port + "/");
                    } else {
                        System.err.println("Failed to listen on port " + port);
                    }
                });
    }

    private int getPort() {
        try {
            return Integer.parseInt(System.getenv("PORT"));
        } catch (NumberFormatException e) {
            // Port used if Vert.x is started locally
            return 5000;
        }
    }
}
