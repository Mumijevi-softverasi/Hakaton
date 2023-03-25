package org.unibl.etf.hakaton.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.hakaton.exceptions.EncryptionException;
import org.unibl.etf.hakaton.models.dto.Bank;
import org.unibl.etf.hakaton.models.dto.BankCardName;
import org.unibl.etf.hakaton.models.dto.NewBank;
import org.unibl.etf.hakaton.models.dto.NewBankCard;
import org.unibl.etf.hakaton.services.BankCardService;
import org.unibl.etf.hakaton.services.BankService;

import java.util.List;

@RestController
@RequestMapping("/bankcards")
public class BankCardController {

    private final BankCardService service;
    public BankCardController(BankCardService service)
    {
        this.service=service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long insert(@RequestBody NewBankCard newBankCard)throws EncryptionException
    {
        return this.service.insert(newBankCard);
    }

    @GetMapping("/{id}")
    public List<BankCardName> getAllBankCardName(@PathVariable Long id)throws EncryptionException
    {
        return this.service.getAllBankCardName(id);
    }
}
