package org.unibl.etf.hakaton.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.hakaton.exceptions.NotFoundException;
import org.unibl.etf.hakaton.models.dto.Bank;
import org.unibl.etf.hakaton.models.dto.NewBank;
import org.unibl.etf.hakaton.models.dto.PaymentInfo;
import org.unibl.etf.hakaton.models.entities.BankEntity;
import org.unibl.etf.hakaton.repositories.BankEntityRepository;
import org.unibl.etf.hakaton.services.BankService;
import org.unibl.etf.hakaton.services.PaymentInfoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/banks")
public class BankController {

    private final BankService service;
    public BankController(BankService service)
    {
        this.service=service;
    }


    @GetMapping
    public List<Bank> getAllBanks()
    {
        return this.service.getAllBanks();
    }

    @GetMapping("/{id}")
    public Bank getBankById(@PathVariable Long id) throws NotFoundException {
        return this.service.getBankByID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBank(@PathVariable Long id) throws NotFoundException {
        this.service.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bank insert(@RequestBody NewBank newBank)
    {
        return this.service.insert(newBank);
    }




}
