package com.vishnu.cloudnine.controller;

import com.vishnu.cloudnine.model.PersonalEventForm;
import com.vishnu.cloudnine.service.PersonalEventFormService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
//        return ResponseEntity.ok("PersonalEventForm saved successfully");
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<PersonalEventForm>> listPersonalFormData() {
        System.out.println("listPersonalFormData===================");
        return ResponseEntity.ok(personalFormService.listPersonalFormData());
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<Void> createPersonalForm(@RequestBody @Valid @NotNull PersonalEventForm personalEventForm) {
        System.out.println("createPersonalForm===================");
        personalFormService.addLecture(personalEventForm);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
    }
//	@DeleteMapping
//	@PutMapping
//	@PatchMapping
}
