package com.reactivespring.reactivespring.repository;

import com.reactivespring.reactivespring.document.Devs;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface DevsRepository extends ReactiveMongoRepository<Devs, String> {
}
