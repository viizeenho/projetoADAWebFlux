package com.projeto.webflux.service;

import com.projeto.webflux.dto.ClientRequestDTO;
import com.projeto.webflux.dto.ClientResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {

    Mono<ClientResponseDTO> createClient(ClientRequestDTO clientDTO);

    Mono<ClientResponseDTO> getClientById(String id);

    Flux<ClientResponseDTO> getAllClients();

    Mono<ClientResponseDTO> updateClient(String id, ClientRequestDTO clientRequestDTO);

    Mono<Void> deleteClient(String id);
}
