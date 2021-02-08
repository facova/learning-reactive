package com.reactivespring.reactivespring.monoandfluxplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FluxAndMonoTest {

    @Test
    public void fluxTest() {

        Flux<String> stringFlux = Flux.just("Tatiane", "É", "Feia")
                .concatWith(Flux.error(new RuntimeException("Erro Aconteceu")))
                .concatWith(Flux.just("Cabou aqui"));

        stringFlux
                .subscribe(System.out::println,
                        (e) -> System.err.println(e),
                        () -> System.out.println("Cabou o programa, acabou"));
    }

    @Test
    public void shouldVerifyWithoutError() {

        Flux<String> stringFlux = Flux.just("Tatiane", "É", "Feia");

        StepVerifier.create(stringFlux)
                .expectNext("Tatiane")
                .expectNext("É")
                .expectNext("Feia")
                .verifyComplete();

    }

    @Test
    public void shouldVerifyWithError() {

        Flux<String> stringFlux = Flux.just("Tatiane", "É", "Feia")
                .concatWith(Flux.error(new RuntimeException("Erro Aconteceu")));

        StepVerifier.create(stringFlux)
                .expectNext("Tatiane")
                .expectNext("É")
                .expectNext("Feia")
                .expectError(RuntimeException.class)
                .verify();

    }

    @Test
    public void shouldVerifyWithErrorCunt() {

        Flux<String> stringFlux = Flux.just("Tatiane", "É", "Feia")
                .concatWith(Flux.error(new RuntimeException("Erro Aconteceu")));

        StepVerifier.create(stringFlux)
                .expectNextCount(3)
                .expectError(RuntimeException.class)
                .verify();

    }

    @Test
    public void shouldVerifyWithErrorWithOneNextLine() {

        Flux<String> stringFlux = Flux.just("Tatiane", "É", "Feia")
                .concatWith(Flux.error(new RuntimeException("Erro Aconteceu")));

        StepVerifier.create(stringFlux)
                .expectNext("Tatiane", "É", "Feia")
                .expectError(RuntimeException.class)
                .verify();

    }

    @Test
    public void shouldVerifyMono(){

        Mono<String> monoString = Mono.just("Spring").log();

        StepVerifier.create(monoString)
                .expectNext("Spring")
                .verifyComplete();
    }

}
