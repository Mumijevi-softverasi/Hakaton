package org.unibl.etf.hakaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.unibl.etf.hakaton.models.dto.BankCardName;
import org.unibl.etf.hakaton.models.entities.BankCardEntity;

import java.util.List;
@Repository
public interface BankCardEntityRepository extends JpaRepository<BankCardEntity,Long> {

    @Query("SELECT new org.unibl.etf.hakaton.models.dto.BankCardName(p.id,p.cardNumber) FROM BankCardEntity p WHERE p.student.id = :id ")
    List<BankCardName> findAllBankCardNames(@Param("id") Long id);
}
