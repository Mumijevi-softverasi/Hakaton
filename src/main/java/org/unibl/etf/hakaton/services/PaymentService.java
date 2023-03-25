package org.unibl.etf.hakaton.services;

import org.unibl.etf.hakaton.exceptions.NotFoundException;
import org.unibl.etf.hakaton.models.dto.Payment;
import org.unibl.etf.hakaton.models.dto.PaymentRequestWithCard;
import org.unibl.etf.hakaton.models.dto.PaymentRequestWithoutCard;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPaymentsById(Long id) throws NotFoundException;
    void insertWithCard(PaymentRequestWithCard request);
    void insertWithoutCard(PaymentRequestWithoutCard request);
}
