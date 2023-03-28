package com.vishnu.cloudnine.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.vishnu.cloudnine.model.CorporateEventForm;
import com.vishnu.cloudnine.service.CorporateEventFormService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/corporateform")
public class CorporateEventFormController {
    private final CorporateEventFormService corporateEventFormService;

    public CorporateEventFormController(CorporateEventFormService corporateEventFormService) {
        this.corporateEventFormService = corporateEventFormService;
    }

    @PostMapping("/post-corporate-form")
    @CrossOrigin(origins = "*")
    public ResponseEntity<CorporateEventForm> postCorporateEventForm(@RequestBody CorporateEventForm corporateEventForm) throws IOException {
        System.out.println("postCorporateEventForm===================");
        corporateEventFormService.saveCorporateEventForm(corporateEventForm);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
    }

    @GetMapping("/corporatelist")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<CorporateEventForm>> listCorporateFormData() throws IOException {
        System.out.println("listCorporateFormData===================");
        return ResponseEntity.ok(corporateEventFormService.listCorporateEventFormData());
    }

    @GetMapping("/{sponsoremail}")
    @CrossOrigin(origins = "*")
    public List<JsonNode> getCorporateFormData(@PathVariable String sponsoremail) throws IOException {
        System.out.println("getPersonalFormData===================" + sponsoremail);
        return ResponseEntity.ok(corporateEventFormService.getCorporateFormData(sponsoremail)).getBody();
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<Void> createCorporateForm(@RequestBody @Valid @NotNull CorporateEventForm lecture) {
        System.out.println("postCorporateEventForm===================");
        corporateEventFormService.addCorporateEventForm(lecture);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();

    }
}
