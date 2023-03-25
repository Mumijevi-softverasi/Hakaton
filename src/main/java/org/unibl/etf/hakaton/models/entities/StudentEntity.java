package org.unibl.etf.hakaton.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.unibl.etf.hakaton.models.util.Status;

import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name="studentEntity")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name="name",nullable = false)
    private String name;

    @Basic
    @Column(name="surname",nullable = false)
    private String surname;

    /*@Basic
    @Column(name="date_of_birth",nullable = false)
    private Date datOfBirth;*/

   @Basic
    @Column(name="birth_place",nullable = false)
    private String birthPlace;

    @Basic
    @Column(name="municipality",nullable = false)
    private String municipality;

    @Basic
    @Column(name="country",nullable = false)
    private String country;

    @Basic
    @Column(name="citizen",nullable = false)
    private String citizen;

    @Basic
    @Column(name="father_job",nullable = false)
    private String fathersJob;

    @Basic
    @Column(name="year_of_study",nullable = false)
    private Integer yearOfStudy;

    @Basic
    @Column(name="study_program",nullable = false)
    private String studyProgram;

    @Basic
    @Column(name="curr_semester",nullable = false)
    private Integer currSemester;

    @Basic
    @Column(name="username",nullable = false)
    private String username;
    @Basic
    @Column(name="specialization",nullable = false)
    private String specialization;

    @Basic
    @Column(name="password",nullable = false)
    private String password;

    @Basic
    @Column(name="email",nullable = false)
    private String email;

    @Basic
    @Column(name="status",nullable = false)
    private Status status;

    @Basic
    @Column(name="address",nullable = false)
    private String address;

    @Basic
    @Column(name="phone_number",nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy="student")
    List<BankCardEntity> bankCards;

}

