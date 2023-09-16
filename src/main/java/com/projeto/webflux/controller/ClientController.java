package com.projeto.webflux.controller;

import com.projeto.webflux.serviceImpl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.projeto.webflux.dto.ClientRequestDTO;
import com.projeto.webflux.dto.ClientResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/clients")
public class ClientController {
	
	@Autowired
	private ClientServiceImpl clientServiceImpl;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	@Operation(description = "Created client",
			   requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody())
	public Mono<ClientResponseDTO> createClient(@RequestBody ClientRequestDTO clientDTO){
		return clientServiceImpl.createClient(clientDTO);
	}

	@GetMapping
	public Flux<ClientResponseDTO> getAllClients() {
		return clientServiceImpl.getAllClients();
	}

	@GetMapping("/{id}")
	public Mono<ClientResponseDTO> getClientById(@PathVariable String id) {
		return clientServiceImpl.getClientById(id);
	}

	@PutMapping("/{id}")
	public Mono<ClientResponseDTO> updateClient(@PathVariable String id, @RequestBody ClientRequestDTO clientRequestDTO) {
		return clientServiceImpl.updateClient(id, clientRequestDTO);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> deleteClient(@PathVariable String id) {
		return clientServiceImpl.deleteClient(id);
	}


}
