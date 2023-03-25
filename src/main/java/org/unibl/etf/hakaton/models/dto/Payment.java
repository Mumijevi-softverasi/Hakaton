package org.unibl.etf.hakaton.models.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Payment {
    private String name;             // PaymentInfo name
    private String recipient;
    private String purposeOfPayment;
    private BigDecimal amount;
    private boolean status;

    public Payment(String name, String recipient, String purposeOfPayment, BigDecimal amount, boolean status) {
        this.name=name;
        this.recipient=recipient;
        this.purposeOfPayment=purposeOfPayment;
        this.amount=amount;
        this.status=status;
    }
}
