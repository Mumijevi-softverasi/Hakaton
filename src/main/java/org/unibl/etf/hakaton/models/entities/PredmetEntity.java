package org.unibl.etf.hakaton.models.entities;

import lombok.Data;

@Data
public class PredmetEntity
{
    private String name;
    private String code;
    private Boolean isReq;
    private String profesor;
    private int ects;
    private int semestar;
    private int yearOfStudy;


    public PredmetEntity(String name,String code,Boolean isReq,String profesor,int ects,int semestar,int yearOfStudy) {
        this.name=name;
        this.code=code;
        this.isReq=isReq;
        this.profesor=profesor;
        this.semestar=semestar;
        this.ects=ects;
        this.yearOfStudy=yearOfStudy;
    }
}
