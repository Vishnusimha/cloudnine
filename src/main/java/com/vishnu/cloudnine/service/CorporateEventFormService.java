package com.vishnu.cloudnine.service;

import com.vishnu.cloudnine.entity.CorporateEventFormEntity;
import com.vishnu.cloudnine.repository.CorporateEventFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CorporateEventFormService {

    @Autowired
    private CorporateEventFormRepository corporateEventFormRepository;

    public List<CorporateEventFormEntity> listCorporateEventFormData() {
        System.out.println(" CorporateEventFormService: listCorporateEventFormData");
        return new ArrayList<>(corporateEventFormRepository.findAll());
    }

    public void saveCorporateEventForm(CorporateEventFormEntity corporateEventFormEntity) {
        System.out.println(" CorporateEventFormService: saveCorporateEventForm");
        corporateEventFormRepository.save(corporateEventFormEntity);
    }

    public void deleteCorporateEventFormBySponsorEmail(String sponsorEmail) {
        System.out.println(" CorporateEventFormService: deleteCorporateEventFormBySponsorEmail");
        corporateEventFormRepository.delete(corporateEventFormRepository.findBySponsorEmail(sponsorEmail));
    }

    public CorporateEventFormEntity getCorporateEventFormBySponsorEmail(String sponsorEmail) {
        System.out.println(" CorporateEventFormService: getCorporateEventFormBySponsorEmail");
     return corporateEventFormRepository.findBySponsorEmail(sponsorEmail);
    }
}
