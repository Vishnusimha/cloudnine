package com.vishnu.cloudnine.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vishnu.cloudnine.model.CorporateEventForm;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CorporateEventFormService {

    public CorporateEventFormService() {

    }

    public List<CorporateEventForm> listCorporateEventFormData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("json/corporate_form.json");
        CorporateEventForm[] forms = objectMapper.readValue(resource.getInputStream(), CorporateEventForm[].class);
        //reading full JSON data from corporate_form.json and returning as a list to controller
        return Arrays.asList(forms);
    }

    public List<JsonNode> getCorporateFormData(String sponsoremail) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("json/corporate_form.json");// getting JSON path as class resource path because if we give normal path it fails when creating WAR file.
        String jsonContent = Files.readString(Paths.get(resource.getURI()));// reading json as a string
        JsonNode jsonNode = objectMapper.readTree(jsonContent);// converting JSON str as json node object

        List<JsonNode> filteredData = new ArrayList<>();
        for (JsonNode node : jsonNode) {
            if (node.get("sponsoremail").asText().equals(sponsoremail)) {// filtering to get the sponsoremail node
                filteredData.add(node);// when matches we take that data and add to filteredData and finally return it to rest controller
            }
        }
        return filteredData;
    }

    public void saveCorporateEventForm(CorporateEventForm corporateEventForm) throws IOException {
        String filename = "corporate_form.json";
        String filePath = "src/main/resources/json/" + filename;

        File file = new File(filePath);
        if (!file.exists()) {// creates new file if the file is not present already
            file.createNewFile();
            System.out.println("createNewFile===================");
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        ObjectWriter writer = mapper.writerFor(new TypeReference<List<CorporateEventForm>>() {
        });
        //ObjectWriter for the type reference List<PersonalEventForm>.
        //created an empty List<PersonalEventForm> object to hold data from the JSON file
        List<CorporateEventForm> corporateEventFormsData = new ArrayList<>();

        if (file.length() > 0) {//If the file length is greater than 0, we read existing data from the JSON file and adds it to the List<PersonalEventForm>.
            System.out.println("add data===================");
            corporateEventFormsData = mapper.readValue(file, new TypeReference<List<CorporateEventForm>>() {
            });
        }
        System.out.println("append data===================");

        corporateEventFormsData.add(corporateEventForm);// appending data

        writer.writeValue(file, corporateEventFormsData);// writing to JSON file
    }
}
