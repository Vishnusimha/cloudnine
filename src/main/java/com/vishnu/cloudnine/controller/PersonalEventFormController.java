package com.vishnu.cloudnine.controller;

import com.vishnu.cloudnine.entity.PersonalEventFormEntity;
import com.vishnu.cloudnine.service.PersonalEventFormService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personalform")
public class PersonalEventFormController {
    private final PersonalEventFormService personalEventFormService;

    public PersonalEventFormController(PersonalEventFormService personalEventFormService) {
        this.personalEventFormService = personalEventFormService;
    }

    @GetMapping("/getpersonalform")
    public List<PersonalEventFormEntity> listPersonalEventFormData() {
        return personalEventFormService.listPersonalEventFormData();
    }

    @GetMapping("/getpersonalform/{sponsorEmail}")
    public PersonalEventFormEntity getPersonalEventFormBySponsorEmail(@PathVariable String sponsorEmail) {
        System.out.println("getPersonalEventFormBySponsorEmail");
        return personalEventFormService.getPersonalEventFormBySponsorEmail(sponsorEmail);
    }

    @PostMapping("/postpersonalform")
    public void savePersonalEventForm(@RequestBody PersonalEventFormEntity personalEventFormEntity) {
        personalEventFormService.savePersonalEventForm(personalEventFormEntity);
    }

    @DeleteMapping("/deletepersonalform/{sponsorEmail}")
    public void deletePersonalEventFormBySponsorEmail(@PathVariable String sponsorEmail) {
        personalEventFormService.deletePersonalEventFormBySponsorEmail(sponsorEmail);
    }
}
