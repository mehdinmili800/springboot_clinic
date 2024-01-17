package com.mehdi.springboot_clinic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mehdi.springboot_clinic.dto.entityDTO.AdminDTO;
import com.mehdi.springboot_clinic.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    //add new admin
    @PostMapping("/create")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<AdminDTO> create(@RequestBody String adminSaveDTO/*, HttpServletRequest request*/) throws JsonProcessingException {

        return new ResponseEntity<>(adminService.create(adminSaveDTO), HttpStatus.CREATED);
    }
}
