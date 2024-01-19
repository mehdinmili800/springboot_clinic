package com.mehdi.springboot_clinic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mehdi.springboot_clinic.dto.entityDTO.FeedbackDTO;
import com.mehdi.springboot_clinic.service.FeedbackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/create")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<FeedbackDTO> leaveFeedback( @RequestBody String feedbackSaveDTO, Principal principal) throws JsonProcessingException {
        return new ResponseEntity<>(feedbackService.create(feedbackSaveDTO, principal), HttpStatus.CREATED);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<FeedbackDTO> getAll(@RequestParam(required = false) String keyword, Principal principal) {
        return feedbackService.getAll(keyword, principal);
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<FeedbackDTO> getById(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(feedbackService.getById(id), HttpStatus.OK);
    }*/

    @GetMapping("/remove/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public String delete(@PathVariable(name = "id") long id) {
        return feedbackService.delete(id);
    }
}

