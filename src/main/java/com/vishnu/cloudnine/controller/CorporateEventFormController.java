package com.vishnu.cloudnine.controller;

import com.vishnu.cloudnine.entity.CorporateEventFormEntity;
import com.vishnu.cloudnine.service.CorporateEventFormService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corporateform")
public class CorporateEventFormController {
    private final CorporateEventFormService corporateEventFormService;

    public CorporateEventFormController(CorporateEventFormService corporateEventFormService) {
        this.corporateEventFormService = corporateEventFormService;
    }

    @GetMapping("/getcorporateform")
    @CrossOrigin(origins = "*")
    public List<CorporateEventFormEntity> listCorporateEventFormData() {
        System.out.println(" CorporateEventFormController: listCorporateEventFormData");
        return corporateEventFormService.listCorporateEventFormData();
    }

    @GetMapping("/getcorporateform/{sponsorEmail}")
    @CrossOrigin(origins = "*")
    public CorporateEventFormEntity getCorporateEventFormBySponsorEmail(@PathVariable String sponsorEmail) {
        System.out.println(" CorporateEventFormController: getCorporateEventFormBySponsorEmail");

        System.out.println("getCorporateEventFormBySponsorEmail");
        return corporateEventFormService.getCorporateEventFormBySponsorEmail(sponsorEmail);
    }

    @PostMapping("/postcorporateform")
    @CrossOrigin(origins = "*")
    public void saveCorporateEventForm(@RequestBody CorporateEventFormEntity corporateEventFormEntity) {
        System.out.println(" CorporateEventFormController: saveCorporateEventForm");
        corporateEventFormService.saveCorporateEventForm(corporateEventFormEntity);
    }

    @DeleteMapping("/deletecorporateform/{sponsorEmail}")
    @CrossOrigin(origins = "*")
    public void deleteCorporateEventForm(@PathVariable String sponsorEmail) {
        System.out.println(" CorporateEventFormController: deleteCorporateEventForm");
        corporateEventFormService.deleteCorporateEventFormBySponsorEmail(sponsorEmail);
    }
}
