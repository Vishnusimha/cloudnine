package com.vishnu.cloudnine.service;

import com.vishnu.cloudnine.entity.PersonalEventFormEntity;
import com.vishnu.cloudnine.repository.PersonalEventFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PersonalEventFormService {

    @Autowired
    private PersonalEventFormRepository personalEventFormRepository;

    public List<PersonalEventFormEntity> listPersonalEventFormData() {
        return new ArrayList<>(personalEventFormRepository.findAll());
    }

    public void savePersonalEventForm(PersonalEventFormEntity personalEventFormEntity) {
        personalEventFormRepository.save(personalEventFormEntity);
    }

    public void deletePersonalEventFormBySponsorEmail(String sponsorEmail) {
        personalEventFormRepository.delete(personalEventFormRepository.findBySponsorEmail(sponsorEmail));
    }

    public PersonalEventFormEntity getPersonalEventFormBySponsorEmail(String sponsorEmail) {
        return personalEventFormRepository.findBySponsorEmail(sponsorEmail);
    }
}
