package com.vishnu.cloudnine.model;

import jakarta.validation.constraints.NotNull;

public class CorporateForm {

    @NotNull
    private Integer week;
    @NotNull
    private String author;
    @NotNull
    private String title;
    @NotNull
    private String preface;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreface() {
        return preface;
    }

    public void setPreface(String preface) {
        this.preface = preface;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }
}
