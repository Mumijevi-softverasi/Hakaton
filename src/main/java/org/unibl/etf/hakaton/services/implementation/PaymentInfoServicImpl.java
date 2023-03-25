package org.unibl.etf.hakaton.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.hakaton.exceptions.NotFoundException;
import org.unibl.etf.hakaton.models.dto.*;
import org.unibl.etf.hakaton.models.entities.PaymentEntity;
import org.unibl.etf.hakaton.models.entities.PaymentInfoEntity;
import org.unibl.etf.hakaton.repositories.PaymentInfoEntityRepository;
import org.unibl.etf.hakaton.services.PaymentInfoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentInfoServicImpl implements PaymentInfoService
{
    private final PaymentInfoEntityRepository repository;
    private final ModelMapper mapper;

    public PaymentInfoServicImpl(PaymentInfoEntityRepository repository,ModelMapper mapper)
    {
        this.repository=repository;
        this.mapper=mapper;
    }


    @Override
    public List<PaymentInfo> getAllPaymentInfo() {
        return this.repository.findAll().stream().map(p->mapper.map(p,PaymentInfo.class)).collect(Collectors.toList());
    }

    @Override
    public PaymentInfo getPaymentInfoByID(Long id) throws NotFoundException {
        return mapper.map(this.repository.findById(id).orElseThrow(NotFoundException::new),PaymentInfo.class);
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        if(!this.repository.existsById(id))
            throw new NotFoundException();
        this.repository.deleteById(id);
    }
    @Override
    public PaymentInfo insert(NewPaymentInfo newPaymentInfo){

        var pinfo=mapper.map(newPaymentInfo, PaymentInfoEntity.class);
        pinfo.setId(null);
        pinfo=this.repository.saveAndFlush(pinfo);
        return mapper.map(pinfo,PaymentInfo.class);
    }

    @Override
    public List<PaymentInfoName> getAllPaymentInfoName()
    {
       return this.repository.findAllEntityNames();
    }
}
