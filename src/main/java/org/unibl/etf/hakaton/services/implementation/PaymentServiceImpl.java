package org.unibl.etf.hakaton.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.hakaton.exceptions.NotFoundException;
import org.unibl.etf.hakaton.models.dto.Payment;
import org.unibl.etf.hakaton.models.dto.PaymentInfo;
import org.unibl.etf.hakaton.models.dto.PaymentRequestWithCard;
import org.unibl.etf.hakaton.models.dto.PaymentRequestWithoutCard;
import org.unibl.etf.hakaton.models.entities.PaymentEntity;
import org.unibl.etf.hakaton.repositories.PaymentEntityRepository;
import org.unibl.etf.hakaton.repositories.PaymentInfoEntityRepository;
import org.unibl.etf.hakaton.repositories.StudentEntityRepository;
import org.unibl.etf.hakaton.services.PaymentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {
    private PaymentEntityRepository paymentEntityRepository;
    private StudentEntityRepository studentEntityRepository;
    private PaymentInfoEntityRepository paymentInfoEntityRepository;
    private ModelMapper mapper;

    public PaymentServiceImpl(PaymentEntityRepository paymentEntityRepository,ModelMapper mapper,StudentEntityRepository studentEntityRepository,PaymentInfoEntityRepository paymentInfoEntityRepository){
        this.paymentEntityRepository=paymentEntityRepository;
        this.mapper=mapper;
        this.studentEntityRepository=studentEntityRepository;
        this.paymentInfoEntityRepository=paymentInfoEntityRepository;
    }
    @Override
    public List<Payment> getAllPaymentsById(Long id) throws NotFoundException{
        if(!this.studentEntityRepository.existsById(id))
            throw new NotFoundException();
        var list = paymentEntityRepository.findAll().stream().filter(el -> {
            return el.getStudent().getId()==id;
        }).collect(Collectors.toList());
        var list2 = new ArrayList<Payment>();
        for(var e:list)
            list2.add(new Payment(e.getPaymentInfo().getName(),e.getPaymentInfo().getRecipient(),e.getPaymentInfo().getPurposeOfPayment(),e.getPaymentInfo().getAmount(),e.isStatus()));
        return list2;
    }

    @Override
    public void insertWithCard(PaymentRequestWithCard request) {
        //var paymentRequest=mapper.map(request, PaymentEntity.class);
        var paymentRequest=new PaymentEntity();
        paymentRequest.setStudent(studentEntityRepository.findById(request.getStudentId()).get());
        paymentRequest.setPaymentInfo(paymentInfoEntityRepository.findById(request.getPaymentInfoId()).get());
        paymentRequest.setId(null);
        paymentRequest.setStatus(true);
        paymentRequest=this.paymentEntityRepository.saveAndFlush(paymentRequest);
    }

    @Override
    public void insertWithoutCard(PaymentRequestWithoutCard request) {
        //var paymentRequest=mapper.map(request, PaymentEntity.class);

        var paymentRequest=new PaymentEntity();
        paymentRequest.setStudent(studentEntityRepository.findById(request.getStudentId()).get());
        paymentRequest.setPaymentInfo(paymentInfoEntityRepository.findById(request.getPaymentInfoId()).get());
        paymentRequest.setId(null);
        paymentRequest.setStatus(true);
        paymentRequest=this.paymentEntityRepository.saveAndFlush(paymentRequest);

    }

}
