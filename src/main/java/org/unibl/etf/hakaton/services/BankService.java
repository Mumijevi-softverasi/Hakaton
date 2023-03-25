package org.unibl.etf.hakaton.services;

import org.springframework.stereotype.Service;
import org.unibl.etf.hakaton.exceptions.NotFoundException;
import org.unibl.etf.hakaton.models.dto.Bank;
import org.unibl.etf.hakaton.models.dto.NewBank;
import org.unibl.etf.hakaton.models.entities.BankEntity;

import java.util.List;

public interface BankService
{
    List<Bank> getAllBanks();
    Bank getBankByID(Long id) throws NotFoundException;

    void delete(Long id) throws NotFoundException;
    Bank insert(NewBank newBank);

}
