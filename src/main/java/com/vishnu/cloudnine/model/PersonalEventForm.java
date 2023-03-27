package com.vishnu.cloudnine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public class PersonalEventForm {

    @JsonProperty("planno")
    private String planNo;

    @JsonProperty("sponsor")
    @NotNull
    private String sponsor;

    @JsonProperty("name")
    @NotNull
    private String name;

    @JsonProperty("sponsoremail")
    @NotNull
    private String sponsorEmail;

    @JsonProperty("occasion")
    @NotNull
    private String occasion;

    @JsonProperty("occasiondate")
    @NotNull
    private String occasionDate;

    @JsonProperty("occasiontime")
    @NotNull
    private String occasionTime;

    @JsonProperty("location")
    @NotNull
    private String location;

    @JsonProperty("fathersday")
    private boolean fathersDay;

    @JsonProperty("mothersday")
    private boolean mothersDay;

    @JsonProperty("anniversary")
    private boolean anniversary;

    @JsonProperty("country")
    @NotNull
    private String country;


    // default constructor
    public PersonalEventForm() {
    }

    // parameterized constructor
    public PersonalEventForm(String planNo, String sponsor, String name, String email, String occasion, String date, String occasionTime, String location, boolean fathersDay, boolean mothersDay, boolean anniversary, String country) {
        this.planNo = planNo;
        this.sponsor = sponsor;
        this.name = name;
        this.sponsorEmail = email;
        this.occasion = occasion;
        this.occasionDate = date;
        this.occasionTime = occasionTime;
        this.location = location;
        this.fathersDay = fathersDay;
        this.mothersDay = mothersDay;
        this.anniversary = anniversary;
        this.country = country;
    }

    // getter and setter methods for all the fields
    public String getPlanNo() {
        return planNo;
    }

    public void setPlanNo(String planNo) {
        this.planNo = planNo;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSponsorEmail() {
        return sponsorEmail;
    }

    public void setSponsorEmail(String sponsorEmail) {
        this.sponsorEmail = sponsorEmail;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public String getOccasionDate() {
        return occasionDate;
    }

    public void setOccasionDate(String occasionDate) {
        this.occasionDate = occasionDate;
    }

    public String getOccasionTime() {
        return occasionTime;
    }

    public void setOccasionTime(String occasionTime) {
        this.occasionTime = occasionTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isFathersDay() {
        return fathersDay;
    }

    public void setFathersDay(boolean fathersDay) {
        this.fathersDay = fathersDay;
    }

    public boolean isMothersDay() {
        return mothersDay;
    }

    public void setMothersDay(boolean mothersDay) {
        this.mothersDay = mothersDay;
    }

    public boolean isAnniversary() {
        return anniversary;
    }

    public void setAnniversary(boolean anniversary) {
        this.anniversary = anniversary;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
