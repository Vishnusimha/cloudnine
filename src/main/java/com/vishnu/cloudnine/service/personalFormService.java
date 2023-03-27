package com.vishnu.cloudnine.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vishnu.cloudnine.model.PersonalForm;
import com.vishnu.cloudnine.util.ErrorCode;
import com.vishnu.cloudnine.util.PersonalFormServiceException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonalFormService {

    private Map<String, PersonalForm> personalFormsKeyData = new HashMap<>();
    private ArrayList<String> keys = new ArrayList();

    public PersonalFormService() {

    }

//    private PersonalForm createPersonalForm(int week, String author, String title, String preface) {
//        PersonalForm personalForm = new PersonalForm();
//        personalForm.se(author);
//        personalForm.setTitle(title);
//        personalForm.setWeek(week);
//        personalForm.setPreface(preface);
//        return personalForm;
//    }

    public List<PersonalForm> listPersonalFormData() {
        System.out.println("listPersonalFormData===================");
        return new ArrayList<>(personalFormsKeyData.values());
    }

    public PersonalForm addLecture(PersonalForm personalForm) {
        if (personalFormsKeyData.containsKey(personalForm.getPlanNo())) {
            throw new PersonalFormServiceException("PersonalForm for this week already exist", ErrorCode.FORM_DUPLICATION);
        }
        personalFormsKeyData.put(personalForm.getPlanNo(), personalForm);
        return personalForm;
    }

    public void savePersonalForm(PersonalForm personalForm) throws IOException {
        String filename = "personal_form.json";
        String filePath = "src/main/resources/json/" + filename;

//        if (keys.contains(personalForm.getPlanNo())) {
//            throw new PersonalFormServiceException("PersonalForm already exist", ErrorCode.FORM_DUPLICATION);
//        }

        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("createNewFile===================");
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        ObjectWriter writer = mapper.writerFor(new TypeReference<List<PersonalForm>>() {
        });

        List<PersonalForm> personalFormsData = new ArrayList<>();

        if (file.length() > 0) {
            System.out.println("add data===================");
            personalFormsData = mapper.readValue(file, new TypeReference<List<PersonalForm>>() {
            });
        }
        System.out.println("append data===================");

        personalFormsData.add(personalForm);

        writer.writeValue(file, personalFormsData);
    }

}
