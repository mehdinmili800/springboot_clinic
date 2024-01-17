package com.mehdi.springboot_clinic.controller;

import com.mehdi.springboot_clinic.dto.entityDTO.RoleDTO;
import com.mehdi.springboot_clinic.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;


    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/create")
    public ResponseEntity<RoleDTO> addNew(@RequestBody String roleName){
        return new ResponseEntity<>(roleService.create(roleName), HttpStatus.CREATED);
    }
}
