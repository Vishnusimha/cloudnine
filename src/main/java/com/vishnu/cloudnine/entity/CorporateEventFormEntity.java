package com.vishnu.cloudnine.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CORPORATE")
public class CorporateEventFormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAN_NO")
    private int planNo;

    @Column(name = "SPONSOR", nullable = false)
    private String sponsor;

    @Column(name = "COMPANY_NAME", nullable = false)
    private String companyName;

    @Column(name = "SPONSOR_EMAIL", nullable = false, unique = true)
//    @Column(name = "SPONSOR_EMAIL", nullable = false)
    private String sponsorEmail;

    @Column(name = "COMPANY_EMAIL")
    private String companyEmail;

    @Column(name = "OCCASION", nullable = false)
    private String occasion;

    @Column(name = "OCCASION_DATE")
    private String occasionDate;

    @Column(name = "OCCASION_TIME")
    private String occasionTime;

    @Column(name = "LOCATION", columnDefinition = "VARCHAR(30) DEFAULT 'DUBLIN'")
    private String location;

    @Column(name = "COUNTRY", columnDefinition = "VARCHAR(30) DEFAULT 'Ireland'")
    private String country;

    @Column(name = "OFFICE_PARTY", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean officeParty;

    @Column(name = "MILESTONE_EVENT", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean milestoneEvent = false;

    @Column(name = "ACHIEVEMENT", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean achievement;


    public CorporateEventFormEntity() {
    }

    public CorporateEventFormEntity(int planNo, String sponsorEmail, String sponsor, String companyName, String companyEmail, String occasion, String occasionDate, String occasionTime, String location, String country, boolean officeParty, boolean milestoneEvent, boolean achievement) {
        this.planNo = planNo;
        this.sponsorEmail = sponsorEmail;
        this.sponsor = sponsor;
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.occasion = occasion;
        this.occasionDate = occasionDate;
        this.occasionTime = occasionTime;
        this.location = location;
        this.country = country;
        this.officeParty = officeParty;
        this.milestoneEvent = milestoneEvent;
        this.achievement = achievement;
    }

    public String getSponsorEmail() {
        return sponsorEmail;
    }

    public void setSponsorEmail(String sponsorEmail) {
        this.sponsorEmail = sponsorEmail;
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
        return milestoneEvent;
    }

    public void setMilestoneEvents(boolean milestoneEvents) {
        this.milestoneEvent = milestoneEvents;
    }

    public boolean isAchievements() {
        return achievement;
    }

    public void setAchievements(boolean achievements) {
        this.achievement = achievements;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPlanNo() {
        return planNo;
    }

    public void setPlanNo(int planNo) {
        this.planNo = planNo;
    }
}
