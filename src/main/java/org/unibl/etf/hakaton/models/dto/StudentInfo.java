package org.unibl.etf.hakaton.models.dto;

import lombok.Data;
import org.unibl.etf.hakaton.models.entities.BankCardEntity;
import org.unibl.etf.hakaton.models.util.Status;

import java.util.Date;
import java.util.List;
@Data
public class StudentInfo {
    private Long id;
    private String name;
    private String surname;
    private Date datOfBirth;
    private String birthPlace;
    private String municipality;
    private String country;
    private String citizen;
    private String fathersJob;
    private Integer yearOfStudy;
    private String studyProgram;
    private Integer currSemester;
    private String username;
    private String specialization;
    private String email;
    private Status status;
    private String address;
    private String phoneNumber;
    private List<BankCardEntity> bankCards;
}
