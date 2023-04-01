package com.vishnu.cloudnine.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.vishnu.cloudnine.model.PersonalEventForm;
import com.vishnu.cloudnine.service.PersonalEventFormService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/personalform")
public class PersonalEventFormController {
    private final PersonalEventFormService personalFormService;

    public PersonalEventFormController(PersonalEventFormService personalFormService) {
        this.personalFormService = personalFormService;
    }

    @PostMapping("/post-personal-form")
    @CrossOrigin(origins = "*")
    public ResponseEntity<PersonalEventForm> postPersonalForm(@RequestBody PersonalEventForm personalEventForm) throws IOException {
        // Saving the PersonalEventForm object to the database using the service
        System.out.println("postPersonalForm===================");
        personalFormService.savePersonalForm(personalEventForm);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
    }

    @GetMapping("/personallist")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<PersonalEventForm>> listPersonalFormData() throws IOException {
        System.out.println("listPersonalFormData===================");
        return ResponseEntity.ok(personalFormService.listPersonalFormData());
    }

    @GetMapping("/{sponsoremail}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<JsonNode>> getPersonalFormData(@PathVariable String sponsoremail) throws IOException {
        System.out.println("getPersonalFormData===================" + sponsoremail);
        System.out.println(personalFormService.getPersonalFormData(sponsoremail));
        return ResponseEntity.ok(personalFormService.getPersonalFormData(sponsoremail));
    }
}
