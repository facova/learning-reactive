package com.reactivespring.reactivespring.services;

import com.reactivespring.reactivespring.document.Devs;
import com.reactivespring.reactivespring.repository.DevsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DevsServiceImpl implements DevsService{

    @Autowired
    DevsRepository devsRepository;

    @Override
    public Flux<Devs> findAll() {
        return devsRepository.findAll();
    }

    @Override
    public Mono<Devs> findById(String id) {
        return devsRepository.findById(id);
    }

    @Override
    public Mono<Devs> save(Devs devs) {
        return devsRepository.save(devs);
    }


}
