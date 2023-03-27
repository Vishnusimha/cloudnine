package com.vishnu.cloudnine.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter
@Setter
@Builder
public class CorporateFormEntity {
//    @Entity(name = "lecture")

//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String subject;
        private String author;
        private String preface;
        private int week;
}
