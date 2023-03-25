package org.unibl.etf.hakaton.services;

import org.unibl.etf.hakaton.exceptions.NotFoundException;
import org.unibl.etf.hakaton.models.dto.*;

import java.util.List;

public interface PaymentInfoService {
   List<PaymentInfo> getAllPaymentInfo();
   PaymentInfo getPaymentInfoByID(Long id) throws NotFoundException;
   List<PaymentInfoName> getAllPaymentInfoName();

   void delete(Long id) throws NotFoundException;
   PaymentInfo insert(NewPaymentInfo newBank);

}
