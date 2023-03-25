package org.unibl.etf.hakaton.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.hakaton.models.dto.YoungStudent;
import org.unibl.etf.hakaton.services.YoungStudentService;

import java.util.List;

@RestController
@RequestMapping("/youngStudents")
public class YoungStudentController
{

    private YoungStudentService service;

    public YoungStudentController(YoungStudentService service)
    {
        this.service=service;
    }
    @GetMapping
    public List<YoungStudent> getAllYoungStudents()
    {
        return this.service.getAllYoungStudent();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public YoungStudent insert(@RequestBody YoungStudent newP)
    {
        return this.service.insert(newP);
    }
}
