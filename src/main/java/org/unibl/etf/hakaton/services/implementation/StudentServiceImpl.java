package org.unibl.etf.hakaton.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.unibl.etf.hakaton.exceptions.NotApprovedException;
import org.unibl.etf.hakaton.exceptions.NotFoundException;
import org.unibl.etf.hakaton.models.dto.Bank;
import org.unibl.etf.hakaton.models.dto.NewStudent;
import org.unibl.etf.hakaton.models.dto.Student;
import org.unibl.etf.hakaton.models.dto.StudentInfo;
import org.unibl.etf.hakaton.repositories.StudentEntityRepository;
import org.unibl.etf.hakaton.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentEntityRepository studentEntityRepository;
    private ModelMapper mapper;

    public StudentServiceImpl(StudentEntityRepository studentEntityRepository,ModelMapper mapper){
        this.studentEntityRepository=studentEntityRepository;
        this.mapper=mapper;
    }


    @Override
    public Student authenticate(NewStudent student) throws NotApprovedException {
        var list = studentEntityRepository.findAll();
        return list.stream().filter(el -> el.getUsername().equals(student.getUsername()) && el.getPassword().equals(student.getPassword()))
                .map(el -> new Student(el.getId(), el.getName(), el.getSurname()))
                .findFirst()
                .orElseThrow(NotApprovedException::new);
    }

    @Override
    public StudentInfo getStudentById(Long id) throws NotFoundException {
        return mapper.map(this.studentEntityRepository.findById(id).orElseThrow(NotFoundException::new), StudentInfo.class);
    }
}
