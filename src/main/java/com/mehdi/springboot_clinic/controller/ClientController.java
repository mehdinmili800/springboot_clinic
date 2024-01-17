package com.mehdi.springboot_clinic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mehdi.springboot_clinic.dto.entityDTO.ClientDTO;
import com.mehdi.springboot_clinic.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;


    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    //create client
    @PostMapping("/create")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<ClientDTO> create(@RequestBody String clientSaveDTO) throws JsonProcessingException {
        return new ResponseEntity<>(clientService.create(clientSaveDTO), HttpStatus.CREATED);

    }
}