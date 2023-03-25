package org.unibl.etf.hakaton.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.hakaton.exceptions.NotFoundException;
import org.unibl.etf.hakaton.models.dto.*;
import org.unibl.etf.hakaton.services.PaymentInfoService;

import java.util.List;

@RestController
@RequestMapping("/paymentInfo")
public class PaymentInfoControler {

    private final PaymentInfoService service;

    public PaymentInfoControler(PaymentInfoService service)
    {
        this.service=service;
    }

    @GetMapping
    public List<PaymentInfo> getAllPaymentInfo()
    {
        return this.service.getAllPaymentInfo();
    }

    @GetMapping("/{id}")
    public PaymentInfo getPaymentInfoById(@PathVariable Long id) throws NotFoundException {
        return this.service.getPaymentInfoByID(id);
    }


    @DeleteMapping("/{id}")
    public void deletePaymentInfo(@PathVariable Long id) throws NotFoundException {
        this.service.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentInfo insert(@RequestBody NewPaymentInfo newP)
    {
        return this.service.insert(newP);
    }

    @GetMapping("/names")
    public List<PaymentInfoName> getAllPaymentInfoName()
    {
        return this.service.getAllPaymentInfoName();
    }
}
