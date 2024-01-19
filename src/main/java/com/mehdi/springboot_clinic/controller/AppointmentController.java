package com.mehdi.springboot_clinic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mehdi.springboot_clinic.dto.entityDTO.AppointmentDTO;
import com.mehdi.springboot_clinic.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    //get all appointments
    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<AppointmentDTO> getAll(@RequestParam(required = false) String keyword, Principal principal) {
        return appointmentService.getAll(keyword, principal);
    }

    //book appointment
    @PostMapping("/create")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<AppointmentDTO> book( @RequestBody String appointmentSaveDTO, Principal principal) throws JsonProcessingException {
        return new ResponseEntity<>(appointmentService.book(appointmentSaveDTO, principal), HttpStatus.CREATED);
    }

    //delete appointment
    @GetMapping("/remove/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public String delete(@PathVariable(name = "id") long id, Principal principal) {
        return appointmentService.delete(id, principal);
    }
}
