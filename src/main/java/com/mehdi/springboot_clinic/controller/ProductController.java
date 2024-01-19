package com.mehdi.springboot_clinic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mehdi.springboot_clinic.dto.entityDTO.ProductDTO;
import com.mehdi.springboot_clinic.repository.ProductRepository;
import com.mehdi.springboot_clinic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductService productService,
                             ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @PostMapping("/create")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<ProductDTO> addNew( @RequestBody String productSaveDTO) throws JsonProcessingException {
        return new ResponseEntity<>(productService.create(productSaveDTO), HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<ProductDTO> update( @RequestBody String productSaveDTO, @PathVariable(name = "id") long id) throws JsonProcessingException {
        return new ResponseEntity<>(productService.update(productSaveDTO, id), HttpStatus.OK);
    }

    @PostMapping("/addStock/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<ProductDTO> addStock(@PathVariable(name = "id") long id, @RequestParam double imported){
        return new ResponseEntity<>(productService.addStock(id, imported), HttpStatus.OK);
    }

    @PutMapping("/remove/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public String delete(@PathVariable(name = "id") long id) {
        return productService.delete(id);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<ProductDTO> get(@RequestParam(required = false) String keyword, Principal principal) {
        return productService.get(keyword, principal);
    }
}
