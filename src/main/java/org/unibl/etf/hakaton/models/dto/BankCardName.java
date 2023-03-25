package org.unibl.etf.hakaton.models.dto;

import lombok.Data;

@Data
public class BankCardName
{
    private Long id;
    private String lastFourDigit;

    public BankCardName(Long id, String lastFourDigit) {
        this.id=id;
        this.lastFourDigit=lastFourDigit;
    }
}
