package org.unibl.etf.hakaton.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.hakaton.exceptions.NotApprovedException;
import org.unibl.etf.hakaton.exceptions.NotFoundException;
import org.unibl.etf.hakaton.models.dto.Bank;
import org.unibl.etf.hakaton.models.dto.NewStudent;
import org.unibl.etf.hakaton.models.dto.Student;
import org.unibl.etf.hakaton.models.dto.StudentInfo;
import org.unibl.etf.hakaton.services.StudentService;

@RestController
@RequestMapping("/login")
public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Student authenticate(@RequestBody NewStudent student) throws NotApprovedException{
        return studentService.authenticate(student);
    }
    @GetMapping("/{id}")
    public StudentInfo getStudentById(@PathVariable Long id) throws NotFoundException {
        return this.studentService.getStudentById(id);
    }

}
