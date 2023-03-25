package org.unibl.etf.hakaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.unibl.etf.hakaton.models.dto.Payment;
import org.unibl.etf.hakaton.models.entities.PaymentEntity;

import java.util.List;
@Repository
public interface PaymentEntityRepository extends JpaRepository<PaymentEntity, Long> {

}
