package org.unibl.etf.hakaton.models.dto;

import lombok.Data;

@Data
public class PaymentInfoName
{
    private Long id;
    private String name;

    public PaymentInfoName(Long id, String name){
        this.id=id;
        this.name=name;
    }
}
