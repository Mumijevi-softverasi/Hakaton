package org.unibl.etf.hakaton.models.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="youngStudent")
public class YoungStudentEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(name="name",nullable = false)
    private String name;
    @Basic
    @Column(name="surname",nullable = false)
    private String surname;
    @Basic
    @Column(name="telephone",nullable = false)
    private String telephone;
    @Basic
    @Column(name="faculty",nullable = false)
    private String faculty;


}
