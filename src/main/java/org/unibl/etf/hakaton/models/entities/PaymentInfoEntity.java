package org.unibl.etf.hakaton.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name="payment_inf" +
        "o_entity")
public class PaymentInfoEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(name="name",nullable = false)
    private String name;
    @Basic
    @Column(name="recipient",nullable = false)
    private String recipient;
    @Basic
    @Column(name="purpose_of_payment",nullable = false)
    private String purposeOfPayment;
    @Basic
    @Column(name="type_of_income",nullable = false)
    private String typeOfIncome;
    @Basic
    @Column(name="city",nullable = false)
    private String city;
    @Basic
    @Column(name="budget_organization",nullable = false)
    private String budgetOrganization;
    @Basic
    @Column(name="reference_number",nullable = false)
    private String referenceNumber;
    @Basic
    @Column(name="amount",nullable = false)
    private BigDecimal amount;


}
