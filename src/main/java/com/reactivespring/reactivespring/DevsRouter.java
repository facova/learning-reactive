package com.reactivespring.reactivespring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

//@Configuration
public class DevsRouter {

    //@Bean
    public RouterFunction<ServerResponse> route(DevsHandler devsHandler) {
        return RouterFunctions.route(GET("/devs").and(accept(MediaType.APPLICATION_JSON)), devsHandler::findAll);

    }

}
