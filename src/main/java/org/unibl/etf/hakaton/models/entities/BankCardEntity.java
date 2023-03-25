package org.unibl.etf.hakaton.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="bank_card_entity")
public class BankCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="student_id",referencedColumnName = "id",nullable = false)
    private StudentEntity student;

    @Basic
    @Column(name="creditCardName",nullable = false)
    private String creditCardName;

    @Basic
    @Column(name="cardNumber",nullable = false)
    private String cardNumber;

    @Basic
    @Column(name="expireDate",nullable = false)
    private String expireDate;

    @Basic
    @Column(name="cvcVcc",nullable = false)
    private String cvcVcc;

}
