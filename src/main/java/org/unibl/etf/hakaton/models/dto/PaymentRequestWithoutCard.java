package org.unibl.etf.hakaton.models.dto;

import lombok.Data;

@Data
public class PaymentRequestWithoutCard {
    private Long studentId;
    private Long paymentInfoId;
    private Long bankId;
    private String creditCardName;
    private String cardNumber;
    private String expireDate;
    private String cvcVcc;
}
