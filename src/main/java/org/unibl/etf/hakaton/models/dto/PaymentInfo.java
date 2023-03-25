package org.unibl.etf.hakaton.models.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class PaymentInfo {
    private Long id;
    private String name;
    private String recipient;
    private String purposeOfPayment;
    private String typeOfIncome;
    private String city;
    private String budgetOrganization;
    private String referenceNumber;
    private BigDecimal amount;
}
