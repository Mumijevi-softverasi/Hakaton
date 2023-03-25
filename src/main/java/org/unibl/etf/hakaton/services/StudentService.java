package org.unibl.etf.hakaton.services;

import org.springframework.http.HttpStatus;
import org.unibl.etf.hakaton.exceptions.NotApprovedException;
import org.unibl.etf.hakaton.exceptions.NotFoundException;
import org.unibl.etf.hakaton.models.dto.NewStudent;
import org.unibl.etf.hakaton.models.dto.Student;
import org.unibl.etf.hakaton.models.dto.StudentInfo;

public interface StudentService {

    Student authenticate(NewStudent student) throws NotApprovedException;
    StudentInfo getStudentById(Long id) throws NotFoundException;


}
