package com.projeto.webflux.serviceImpl;

import com.projeto.webflux.dto.ClientRequestDTO;
import com.projeto.webflux.dto.ClientResponseDTO;
import com.projeto.webflux.conversor.ClientConversor;
import com.projeto.webflux.model.Client;
import com.projeto.webflux.repository.ClientRepository;
import com.projeto.webflux.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private final ClientRepository clientRepository;
    @Autowired
    private final ClientConversor clientConversor;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ClientConversor clientConversor) {
        this.clientRepository = clientRepository;
        this.clientConversor = clientConversor;
    }

    @Override
    public Mono<ClientResponseDTO> createClient(ClientRequestDTO clientDTO) {
        Client client = this.clientConversor.toEntity(clientDTO);

        return this.clientRepository.save(client)
                .map(clientConversor::toDTO);
    }

    @Override
    public Mono<ClientResponseDTO> getClientById(String id) {
        return clientRepository.findById(id)
                .map(clientConversor::toDTO);
    }

    @Override
    public Flux<ClientResponseDTO> getAllClients() {
        return clientRepository.findAll()
                .map(clientConversor::toDTO);
    }

    @Override
    public Mono<ClientResponseDTO> updateClient(String id, ClientRequestDTO clientRequestDTO) {
        return clientRepository.findById(id)
                .flatMap(existingClient -> {
                    existingClient.setName(clientRequestDTO.getName());
                    return clientRepository.save(existingClient)
                            .map(clientConversor::toDTO);
                });
    }

    @Override
    public Mono<Void> deleteClient(String id) {
        return clientRepository.findById(id)
                .flatMap(existingClient -> clientRepository.delete(existingClient));
    }

}

