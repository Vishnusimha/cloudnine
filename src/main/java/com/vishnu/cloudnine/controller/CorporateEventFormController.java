package com.vishnu.cloudnine.controller;

import com.vishnu.cloudnine.model.CorporateForm;
import com.vishnu.cloudnine.service.CorporateFormService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corporate/event")
public class CorporateEventFormController {
    private final CorporateFormService corporateFormService;

    public CorporateEventFormController(CorporateFormService corporateFormService) {
        this.corporateFormService = corporateFormService;
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<CorporateForm>> listCorporateFormData() {
        return ResponseEntity.ok(corporateFormService.listCorporateFormData());
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<Void> createCorporateForm(@RequestBody @Valid @NotNull CorporateForm lecture) {
        corporateFormService.addLecture(lecture);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();

    }
//	@DeleteMapping
//	@PutMapping
//	@PatchMapping
}
