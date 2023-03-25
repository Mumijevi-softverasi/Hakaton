package org.unibl.etf.hakaton.services;

import org.springframework.stereotype.Service;
import org.unibl.etf.hakaton.models.entities.PredmetEntity;
import org.unibl.etf.hakaton.repositories.PredmetEntityRepository;

import java.util.List;

@Service
public class PredmetService {
    private final PredmetEntityRepository repository;

    public PredmetService(PredmetEntityRepository repository)
    {
        this.repository=repository;
    }



    List<PredmetEntity> getPredmetsForVerifyByStudentId()
    {
       return this.repository.getPredmetsForVerifyByStudentId();
    }

    List<PredmetEntity> getPredmetsForEnrolByStuddentId()
    {
        return this.repository.getPredmetsForEnrolByStuddentId();
    }
}
