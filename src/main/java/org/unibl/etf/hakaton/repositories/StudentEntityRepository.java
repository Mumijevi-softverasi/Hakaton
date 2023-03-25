package org.unibl.etf.hakaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unibl.etf.hakaton.models.entities.StudentEntity;

@Repository
public interface StudentEntityRepository extends JpaRepository<StudentEntity, Long> {
}
