package com.vishnu.cloudnine.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vishnu.cloudnine.model.PersonalEventForm;
import com.vishnu.cloudnine.util.ErrorCode;
import com.vishnu.cloudnine.util.PersonalEventFormServiceException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonalEventFormService {

    private Map<String, PersonalEventForm> personalFormsKeyData = new HashMap<>();
    private ArrayList<String> keys = new ArrayList();

    public PersonalEventFormService() {

    }

//    private PersonalEventForm createPersonalForm(int week, String author, String title, String preface) {
//        PersonalEventForm personalForm = new PersonalEventForm();
//        personalForm.se(author);
//        personalForm.setTitle(title);
//        personalForm.setWeek(week);
//        personalForm.setPreface(preface);
//        return personalForm;
//    }

    public List<PersonalEventForm> listPersonalFormData() {
        System.out.println("listPersonalFormData===================");
        return new ArrayList<>(personalFormsKeyData.values());
    }

    public PersonalEventForm addLecture(PersonalEventForm personalEventForm) {
        if (personalFormsKeyData.containsKey(personalEventForm.getPlanNo())) {
            throw new PersonalEventFormServiceException("PersonalEventForm for this week already exist", ErrorCode.FORM_DUPLICATION);
        }
        personalFormsKeyData.put(personalEventForm.getPlanNo(), personalEventForm);
        return personalEventForm;
    }

    public void savePersonalForm(PersonalEventForm personalEventForm) throws IOException {
        String filename = "personal_form.json";
        String filePath = "src/main/resources/json/" + filename;

//        if (keys.contains(personalEventForm.getPlanNo())) {
//            throw new PersonalEventFormServiceException("PersonalEventForm already exist", ErrorCode.FORM_DUPLICATION);
//        }

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
