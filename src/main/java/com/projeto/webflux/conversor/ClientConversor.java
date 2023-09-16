package com.projeto.webflux.conversor;

import com.projeto.webflux.dto.ClientResponseDTO;

import com.projeto.webflux.dto.ClientRequestDTO;
import com.projeto.webflux.model.Client;
import org.springframework.stereotype.Component;


@Component
public class ClientConversor {

   public ClientResponseDTO toDTO(Client client){
       ClientResponseDTO responseDTO = new ClientResponseDTO();
       responseDTO.setId(client.getId());
       responseDTO.setName(client.getName());
       responseDTO.setAge(client.getAge());
       responseDTO.setEmail(client.getEmail());
       return  responseDTO;
   }

    public Client toEntity(ClientRequestDTO dto){
       Client client =  new Client();
       client.setName(dto.getName());
       client.setAge(dto.getAge());
       client.setEmail(dto.getEmail());
       return client;
    }
}
