package com.reactivespring.reactivespring.services;

import com.reactivespring.reactivespring.document.Devs;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DevsService {

    Flux<Devs> findAll();
    Mono<Devs> findById(String id);
    Mono<Devs> save(Devs devs);
}
