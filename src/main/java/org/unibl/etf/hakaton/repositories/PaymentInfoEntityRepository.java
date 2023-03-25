package org.unibl.etf.hakaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.unibl.etf.hakaton.models.dto.PaymentInfoName;
import org.unibl.etf.hakaton.models.entities.PaymentInfoEntity;

import java.util.List;

@Repository
public interface PaymentInfoEntityRepository extends JpaRepository<PaymentInfoEntity,Long>{
    @Query("SELECT new org.unibl.etf.hakaton.models.dto.PaymentInfoName(p.id,p.name) FROM PaymentInfoEntity p")
    List<PaymentInfoName> findAllEntityNames();
}
