package com.projeto.webflux.repository;

import com.projeto.webflux.model.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


@Repository
public interface ClientRepository extends ReactiveMongoRepository<Client, String>{

}
