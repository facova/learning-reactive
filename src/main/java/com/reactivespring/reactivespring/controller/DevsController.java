package com.reactivespring.reactivespring.controller;

import com.reactivespring.reactivespring.document.Devs;
import com.reactivespring.reactivespring.services.DevsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.time.LocalDateTime;

@Log4j2
@RestController
public class DevsController {

    @Autowired
    DevsService devsService;

    @GetMapping(value = "/devs")
    public Flux<Devs> getDevs() {
        return devsService.findAll();
    }

    @GetMapping(value = "/devs/{id}")
    public Mono<Devs> getDevsById(@PathVariable String id) {
        return devsService.findById(id);
    }

    @PostMapping(value = "/devs")
    public Mono<Devs> save(@RequestBody Devs devs) {
        return devsService.save(devs);
    }

    @GetMapping(value = "/devs/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Devs>> event() {

       log.info("Starting get Devs by WebFlux" + LocalDateTime.now());
       Flux<Long> interval = Flux.interval(Duration.ofSeconds(5));
       Flux<Devs> devsFlux = devsService.findAll();
       return Flux.zip(interval, devsFlux).log();
    }

}
