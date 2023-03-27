package com.vishnu.cloudnine.service;

import com.vishnu.cloudnine.model.CorporateForm;
import com.vishnu.cloudnine.util.ErrorCode;
import com.vishnu.cloudnine.util.PersonalEventFormServiceException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CorporateFormService {

    private Map<Integer, CorporateForm> corporateForms = new HashMap<>();

    public CorporateFormService() {
        corporateForms.put(1, createCorporateForm(1, "VISHNU CORPORATE DUSSA", "Introduction to the Web Applications and HTML", "What is the Web?\n" +
                "How is the Web built?\n" +
                "What is W3C and why it is so important?\n" +
                "What are the HTTP, FTP and HTTPS?\n" +
                "What is a URI, URL, IP, and DNS?\n" +
                "What is HTML and where to find it?"));
        corporateForms.put(2, createCorporateForm(2, "HEMS", "HTML5 and CSSL", "HTML 5\n" +
                "Media Tags\n" +
                "3Schools Tutorial on HTML 5" +
                "Cascading Style Sheets\n" +
                "Why we need CSS and how to create CSS\n" +
                "CSS Rules\n" +
                "W3Schools Tutorial on CSS"));
        corporateForms.put(3, createCorporateForm(3, "TEZHA", "Java Script", "Document Object Models\n" +
                "Java Script\n" +
                "How to create different JS functions\n" +
                "Making Web pages interactive" +
                "Syntax of JavaScript\n" +
                "Variables, functions, classes, objects, …\n" +
                "Dynamic Web Contents\n" +
                "Events Handling and Actions\n" +
                "Forms Validation"));
        corporateForms.put(4, createCorporateForm(4, "HRITHIK", "Java Script 2 - DOM-JQuery, AJAX-JSON", "JQuery\n" +
                "JQuery Events\n" +
                "AJQuery Traversing\n" +
                "JSON\n" +
                "Ajax Intro\n" +
                "Bootstrap"));
        corporateForms.put(5, createCorporateForm(5, "Ali Intizar", "IDE for Web Development, Intro to Server-side Programming", "We will start preparing the environment for\n" +
                "Eclipse IDE\n" +
                "Creating a Dynamic Web Project\n" +
                "Tomcat Web Server"));
        corporateForms.put(6, createCorporateForm(6, "Ali Intizar", "Relational Database Management Systems and Structured Query Language (SQL)", "What is a relational database?\n" +
                "What are relational Database Management Systems?\n" +
                "SQL Query Language?\n" +
                "How to create a database?\n" +
                "Learn SQL Query Syntax"));
        corporateForms.put(7, createCorporateForm(7, "Katarzyna Fidos", "Backend Development Introduction", "What are main backend architectures nowadays?\n" +
                "What is Rest?\n" +
                "What is Spring framework?\n" +
                "What is Dependency Injection\n" +
                "How to build and run simple service using SpringBoot?"));
    }

    private CorporateForm createCorporateForm(int week, String author, String title, String preface) {
        CorporateForm personalForm = new CorporateForm();
        personalForm.setAuthor(author);
        personalForm.setTitle(title);
        personalForm.setWeek(week);
        personalForm.setPreface(preface);
        return personalForm;
    }

    public List<CorporateForm> listCorporateFormData() {
        return corporateForms.values().stream().collect(Collectors.toList());

    }

    public CorporateForm addLecture(CorporateForm personalForm) {
        if (corporateForms.containsKey(personalForm.getWeek())) {
            throw new PersonalEventFormServiceException("CorporateForm for this week already exist", ErrorCode.FORM_DUPLICATION);
        }
        corporateForms.put(personalForm.getWeek(), personalForm);
        return personalForm;

    }
}
