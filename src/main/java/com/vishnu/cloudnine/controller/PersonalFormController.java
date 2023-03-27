package com.vishnu.cloudnine.controller;

import com.vishnu.cloudnine.model.PersonalForm;
import com.vishnu.cloudnine.service.PersonalFormService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/personalform")
public class PersonalFormController {
    private final PersonalFormService personalFormService;

    public PersonalFormController(PersonalFormService personalFormService) {
        this.personalFormService = personalFormService;
    }

    @PostMapping("/post-personal-form")
    @CrossOrigin(origins = "*")
    public ResponseEntity<PersonalForm> postPersonalForm(@RequestBody PersonalForm personalForm) throws IOException {
        // Saving the PersonalForm object to the database using the service
        System.out.println("postPersonalForm===================");
        personalFormService.savePersonalForm(personalForm);
//        return ResponseEntity.ok("PersonalForm saved successfully");
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<PersonalForm>> listPersonalFormData() {
        System.out.println("listPersonalFormData===================");
        return ResponseEntity.ok(personalFormService.listPersonalFormData());
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<Void> createPersonalForm(@RequestBody @Valid @NotNull PersonalForm personalForm) {
        System.out.println("createPersonalForm===================");
        personalFormService.addLecture(personalForm);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
    }
//	@DeleteMapping
//	@PutMapping
//	@PatchMapping
}
