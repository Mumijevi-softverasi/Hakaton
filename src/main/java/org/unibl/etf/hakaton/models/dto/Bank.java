package org.unibl.etf.hakaton.models.dto;

import lombok.Data;

@Data
public class Bank {
    private Long id;
    private String transactionID;  // An integer that stores a unique identifier for the bank
    private String name;           // A string that stores the name of the bank



}
