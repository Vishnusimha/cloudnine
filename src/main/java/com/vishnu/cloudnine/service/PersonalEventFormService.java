package com.vishnu.cloudnine.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vishnu.cloudnine.model.PersonalEventForm;
import com.vishnu.cloudnine.util.ErrorCode;
import com.vishnu.cloudnine.util.PersonalEventFormServiceException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


@Service
public class PersonalEventFormService {
    private static final String JSON_FILE_PATH = "src/main/resources/json/personal_form.json";

    private Map<String, PersonalEventForm> personalFormsKeyData = new HashMap<>();
    private ArrayList<String> keys = new ArrayList();

    public PersonalEventFormService() {

    }

    public List<PersonalEventForm> listPersonalFormData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("json/personal_form.json");
        PersonalEventForm[] forms = objectMapper.readValue(resource.getInputStream(), PersonalEventForm[].class);
        return Arrays.asList(forms);
    }

    public List<JsonNode> getPersonalFormData(String sponsoremail) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonContent = Files.readString(Paths.get(JSON_FILE_PATH));
        JsonNode jsonNode = objectMapper.readTree(jsonContent);

        List<JsonNode> filteredData = new ArrayList<>();
        for (JsonNode node : jsonNode) {
            if (node.get("sponsoremail").asText().equals(sponsoremail)) {
                filteredData.add(node);
            }
        }
        return filteredData;
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
