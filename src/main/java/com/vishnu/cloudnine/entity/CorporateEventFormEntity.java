package com.vishnu.cloudnine.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CorporateEventFormEntity {
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
