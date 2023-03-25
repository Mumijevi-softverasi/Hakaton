package org.unibl.etf.hakaton.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.hakaton.exceptions.NotFoundException;
import org.unibl.etf.hakaton.models.dto.Payment;
import org.unibl.etf.hakaton.models.dto.PaymentInfo;
import org.unibl.etf.hakaton.models.dto.PaymentRequestWithCard;
import org.unibl.etf.hakaton.models.dto.PaymentRequestWithoutCard;
import org.unibl.etf.hakaton.services.BankCardService;
import org.unibl.etf.hakaton.services.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service)
    {
        this.service=service;
    }

    @GetMapping("/{id}")
    public List<Payment> getAllPaymentsById(@PathVariable Long id) throws NotFoundException
    {
        return this.service.getAllPaymentsById(id);
    }

    @PostMapping("/withCards")
    @ResponseStatus(HttpStatus.CREATED)
     public void insertWithCard(@RequestBody PaymentRequestWithCard request)
    {
        this.service.insertWithCard(request);
    }

    @PostMapping("/withoutCards")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertWithoutCard(@RequestBody PaymentRequestWithoutCard request)
    {
        this.service.insertWithoutCard(request);
    }




}
