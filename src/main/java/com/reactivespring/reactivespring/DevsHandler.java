package com.reactivespring.reactivespring;

import com.reactivespring.reactivespring.document.Devs;
import com.reactivespring.reactivespring.services.DevsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class DevsHandler {

    @Autowired
    DevsService devsService;

    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(devsService.findAll(), Devs.class);
    }
}
