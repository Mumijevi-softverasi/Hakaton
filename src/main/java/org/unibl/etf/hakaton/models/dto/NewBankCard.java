package org.unibl.etf.hakaton.models.dto;

import jakarta.persistence.*;
import lombok.Data;
import org.unibl.etf.hakaton.models.entities.StudentEntity;

@Data
public class NewBankCard
{
    private Long studentId;
    private String creditCardName;
    private String cardNumber;
    private String expireDate;
    private String cvcVcc;
}
