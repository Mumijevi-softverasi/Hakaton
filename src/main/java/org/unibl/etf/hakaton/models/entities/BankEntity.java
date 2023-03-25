package org.unibl.etf.hakaton.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="bank_entity")
public class BankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;               // Database key

    @Basic
    @Column(name="transactionid",nullable = false)
    private String transactionID;  // An integer that stores a unique identifier for the bank

    @Basic
    @Column(name="name",nullable = false)
    private String name;           // A string that stores the name of the bank
}
