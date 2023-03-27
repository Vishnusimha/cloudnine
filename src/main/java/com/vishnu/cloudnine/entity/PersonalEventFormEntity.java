package com.vishnu.cloudnine.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter
@Setter
@Builder
public class PersonalEventFormEntity {
//    @Entity(name = "personalform")

    //        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String planNo;
    private String sponsor;
    private String name;
    private String email;
    private String occasion;
    private String date;
    private String occasionTime;
    private String location;
    private boolean fathersDay;
    private boolean mothersDay;
    private boolean anniversary;
    private String country;
}
