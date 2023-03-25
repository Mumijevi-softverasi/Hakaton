package org.unibl.etf.hakaton.models.dto;

import lombok.Data;

@Data
public class PaymentRequestWithCard
{
    private Long studentId;
    private Long paymentInfoId;
    private Long bankId;
    private Long cardId;
}
