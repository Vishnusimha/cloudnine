package com.vishnu.cloudnine.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vishnu.cloudnine.model.PersonalEventForm;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalEventFormService {

    public PersonalEventFormService() {

    }

    public void savePersonalForm(PersonalEventForm personalEventForm) throws IOException {
        String filename = "personal_form.json";
        String filePath = "src/main/resources/json/" + filename;

        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("createNewFile===================");
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        ObjectWriter writer = mapper.writerFor(new TypeReference<List<PersonalEventForm>>() {
        });

        List<PersonalEventForm> personalEventFormsData = new ArrayList<>();

        if (file.length() > 0) {
            System.out.println("add data===================");
            personalEventFormsData = mapper.readValue(file, new TypeReference<List<PersonalEventForm>>() {
            });
        }
        System.out.println("append data===================");

        personalEventFormsData.add(personalEventForm);

        writer.writeValue(file, personalEventFormsData);
    }

}
