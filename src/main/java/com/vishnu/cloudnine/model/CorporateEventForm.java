package com.vishnu.cloudnine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public class CorporateEventForm {

    @JsonProperty("planno")
    private String planNo;

    @JsonProperty("sponsor")
    @NotNull
    private String sponsor;

    @JsonProperty("companyname")
    @NotNull
    private String companyName;

    @JsonProperty("sponsoremail")
    @NotNull
    private String sponsorEmail;

    @JsonProperty("companyemail")
    @NotNull
    private String companyEmail;

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

    @JsonProperty("officeparty")
    private boolean officeParty;

    @JsonProperty("milestoneevents")
    private boolean milestoneEvents;

    @JsonProperty("achievements")
    private boolean achievements;

    @JsonProperty("country")
    @NotNull
    private String country;

    public CorporateEventForm() {
        // empty constructor
    }

    public CorporateEventForm(String planNo, String sponsor, String companyName, String sponsorEmail, String companyEmail,
                              String occasion, String occasionDate, String occasionTime, String location,
                              boolean officeParty, boolean milestoneEvents, boolean achievements, String country) {
        this.planNo = planNo;
        this.sponsor = sponsor;
        this.companyName = companyName;
        this.sponsorEmail = sponsorEmail;
        this.companyEmail = companyEmail;
        this.occasion = occasion;
        this.occasionDate = occasionDate;
        this.occasionTime = occasionTime;
        this.location = location;
        this.officeParty = officeParty;
        this.milestoneEvents = milestoneEvents;
        this.achievements = achievements;
        this.country = country;
    }

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSponsorEmail() {
        return sponsorEmail;
    }

    public void setSponsorEmail(String sponsorEmail) {
        this.sponsorEmail = sponsorEmail;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
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

    public boolean isOfficeParty() {
        return officeParty;
    }

    public void setOfficeParty(boolean officeParty) {
        this.officeParty = officeParty;
    }

    public boolean isMilestoneEvents() {
        return milestoneEvents;
    }

    public void setMilestoneEvents(boolean milestoneEvents) {
        this.milestoneEvents = milestoneEvents;
    }

    public boolean isAchievements() {
        return achievements;
    }

    public void setAchievements(boolean achievements) {
        this.achievements = achievements;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
