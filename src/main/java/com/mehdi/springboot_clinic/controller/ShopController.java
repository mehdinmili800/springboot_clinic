package com.mehdi.springboot_clinic.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.mehdi.springboot_clinic.dto.entityDTO.ShopDTO;
import com.mehdi.springboot_clinic.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/create")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<ShopDTO> addNew( @RequestBody String shopSaveDTO) throws JsonProcessingException {
        return new ResponseEntity<>(shopService.create(shopSaveDTO), HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<ShopDTO> update( @RequestBody String shopSaveDTO, @PathVariable(name = "id") long id) throws JsonProcessingException {
        return new ResponseEntity<>(shopService.update(shopSaveDTO, id), HttpStatus.OK);
    }

    @GetMapping("/remove/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public String delete(@PathVariable(name = "id") long id) {
        return shopService.delete(id);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<ShopDTO> get(@RequestParam(required = false) String keyword, Principal principal) {
        return shopService.get(keyword, principal);
    }
}

