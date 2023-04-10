package com.vishnu.cloudnine.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PERSONAL")
public class PersonalEventFormEntity {
    @Id
    @Column(name = "SPONSOR_EMAIL", length = 80)
    private String sponsorEmail;

    @Column(name = "PLAN_NO")
    private Integer planNo;

    @Column(name = "NAME", nullable = false, length = 30)
    private String name;

    @Column(name = "SPONSOR", nullable = false, length = 30)
    private String sponsor;

    @ManyToOne
    @JoinColumn(name = "SPONSOR_EMAIL", referencedColumnName = "SPONSOR_EMAIL", insertable = false, updatable = false)
    private CorporateEventFormEntity corporateEventFormEntity;

    @Column(name = "OCCASION", nullable = false, length = 30)
    private String occasion;

    @Column(name = "OCCASION_DATE", length = 30)
    private String occasionDate;

    @Column(name = "OCCASION_TIME", length = 30)
    private String occasionTime;

    @Column(name = "LOCATION", length = 30, columnDefinition = "VARCHAR(30) DEFAULT 'DUBLIN'")
    private String location;

    @Column(name = "COUNTRY", length = 30, columnDefinition = "VARCHAR(30) DEFAULT 'Ireland'")
    private String country;

    @Column(name = "ANNIVERSARY", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean anniversary;

    @Column(name = "MOTHERS_DAY", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean mothersDay;

    @Column(name = "FATHERS_DAY", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean fathersDay;

    public PersonalEventFormEntity() {

    }

    public PersonalEventFormEntity(String sponsorEmail, Integer planNo, String name, String sponsor, CorporateEventFormEntity corporateEventFormEntity, String occasion, String occasionDate, String occasionTime, String location, String country, boolean anniversary, boolean mothersDay, boolean fathersDay) {
        this.sponsorEmail = sponsorEmail;
        this.planNo = planNo;
        this.name = name;
        this.sponsor = sponsor;
        this.corporateEventFormEntity = corporateEventFormEntity;
        this.occasion = occasion;
        this.occasionDate = occasionDate;
        this.occasionTime = occasionTime;
        this.location = location;
        this.country = country;
        this.anniversary = anniversary;
        this.mothersDay = mothersDay;
        this.fathersDay = fathersDay;
    }

    public String getSponsorEmail() {
        return sponsorEmail;
    }

    public void setSponsorEmail(String sponsorEmail) {
        this.sponsorEmail = sponsorEmail;
    }

    public Integer getPlanNo() {
        return planNo;
    }

    public void setPlanNo(Integer planNo) {
        this.planNo = planNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public CorporateEventFormEntity getCorporateEventFormEntity() {
        return corporateEventFormEntity;
    }

    public void setCorporateEventFormEntity(CorporateEventFormEntity corporateEventFormEntity) {
        this.corporateEventFormEntity = corporateEventFormEntity;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean getAnniversary() {
        return anniversary;
    }

    public void setAnniversary(boolean anniversary) {
        this.anniversary = anniversary;
    }

    public boolean getMothersDay() {
        return mothersDay;
    }

    public void setMothersDay(boolean mothersDay) {
        this.mothersDay = mothersDay;
    }

    public boolean getFathersDay() {
        return fathersDay;
    }

    public void setFathersDay(boolean fathersDay) {
        this.fathersDay = fathersDay;
    }
}
