package org.unibl.etf.hakaton.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.hakaton.exceptions.NotFoundException;
import org.unibl.etf.hakaton.models.dto.Bank;
import org.unibl.etf.hakaton.models.dto.NewBank;
import org.unibl.etf.hakaton.models.entities.BankEntity;
import org.unibl.etf.hakaton.repositories.BankEntityRepository;
import org.unibl.etf.hakaton.services.BankService;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class BankServiceImpl implements BankService {

    private final BankEntityRepository repository;
    private final ModelMapper mapper;
    public BankServiceImpl(BankEntityRepository repository, ModelMapper mapper)
    {
        this.repository=repository;
        this.mapper = mapper;
    }
    @Override
   public List<Bank> getAllBanks(){
        //return this.repository.findAll();i
        return this.repository.findAll().stream().map(p->mapper.map(p, Bank.class)).collect(Collectors.toList());
       // return Arrays.asList(new Bank("111111", "NLB"));
    }
    @Override
    public Bank getBankByID(Long id) throws NotFoundException {
       return mapper.map(this.repository.findById(id).orElseThrow(NotFoundException::new),Bank.class);
    }
    @Override
    public void delete(Long id) throws NotFoundException {
        if(!this.repository.existsById(id))
            throw new NotFoundException();
        this.repository.deleteById(id);
    }
    @Override
    public Bank insert(NewBank newBank){

        var bank=mapper.map(newBank,BankEntity.class);
        bank.setId(null);
        bank=this.repository.saveAndFlush(bank);
        return mapper.map(bank,Bank.class);
    }

}
