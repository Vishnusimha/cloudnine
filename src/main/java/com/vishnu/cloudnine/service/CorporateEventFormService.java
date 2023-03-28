package com.vishnu.cloudnine.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vishnu.cloudnine.model.CorporateEventForm;
import com.vishnu.cloudnine.util.ErrorCode;
import com.vishnu.cloudnine.util.PersonalEventFormServiceException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class CorporateEventFormService {
    private Map<String, CorporateEventForm> corporateEventFormsData = new HashMap<>();
    private ArrayList<String> keys = new ArrayList();

    public CorporateEventFormService() {

    }

    public List<CorporateEventForm> listCorporateEventFormData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("json/corporate_form.json");
        CorporateEventForm[] forms = objectMapper.readValue(resource.getInputStream(), CorporateEventForm[].class);
        return Arrays.asList(forms);
    }

    public CorporateEventForm addCorporateEventForm(CorporateEventForm corporateEventForm) {
        if (corporateEventFormsData.containsKey(corporateEventForm.getPlanNo())) {
            throw new PersonalEventFormServiceException("CorporateEventForm for this week already exist", ErrorCode.FORM_DUPLICATION);
        }
        corporateEventFormsData.put(corporateEventForm.getPlanNo(), corporateEventForm);
        return corporateEventForm;
    }

    public void saveCorporateEventForm(CorporateEventForm corporateEventForm) throws IOException {
        String filename = "corporate_form.json";
        String filePath = "src/main/resources/json/" + filename;

        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("createNewFile===================");
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        ObjectWriter writer = mapper.writerFor(new TypeReference<List<CorporateEventForm>>() {
        });

        List<CorporateEventForm> corporateEventFormsData = new ArrayList<>();

        if (file.length() > 0) {
            System.out.println("add data===================");
            corporateEventFormsData = mapper.readValue(file, new TypeReference<List<CorporateEventForm>>() {
            });
        }
        System.out.println("append data===================");

        corporateEventFormsData.add(corporateEventForm);

        writer.writeValue(file, corporateEventFormsData);
    }

}
