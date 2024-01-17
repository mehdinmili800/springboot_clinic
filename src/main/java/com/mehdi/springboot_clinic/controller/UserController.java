package com.mehdi.springboot_clinic.controller;

import com.mehdi.springboot_clinic.dto.entityDTO.UserDTO;
import com.mehdi.springboot_clinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<UserDTO> get(@RequestParam(required = false) String keyword, Principal principal) {
        return userService.get(keyword, principal);
    }

}
