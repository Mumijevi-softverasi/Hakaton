package org.unibl.etf.hakaton.models.dto;

import jakarta.persistence.*;
import lombok.Data;
import org.unibl.etf.hakaton.models.util.Status;

import java.util.Date;

@Data
public class Student {

        private Long id;
        private String name;
        private String surname;
        public Student(Long id, String name, String surname){
                this.id=id;
                this.name=name;
                this.surname=surname;
        }
//    private Date datOfBirth;
//    private String birthPlace;
//    private String municipality;
//    private String country;
//    private String citizen;
//    private String fathersJob;
//    private Integer yearOfStudy;
//    private String studyProgram;
//    private Integer currSemester;
//    private String username;
//    private String specialization;
//    private String email;
//    private Status status;
//    private String address;
//    private String phoneNumber;

}
