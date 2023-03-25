package org.unibl.etf.hakaton.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.hakaton.models.dto.YoungStudent;
import org.unibl.etf.hakaton.models.entities.YoungStudentEntity;
import org.unibl.etf.hakaton.repositories.YoungStudentEntityRepository;
import org.unibl.etf.hakaton.services.YoungStudentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class YoungStudentServiceImpl implements YoungStudentService
{
    private YoungStudentEntityRepository repository;
    private final ModelMapper mapper;

    public YoungStudentServiceImpl(YoungStudentEntityRepository repository,ModelMapper mapper)
    {
        this.repository=repository;
        this.mapper = mapper;
    }

    public List<YoungStudent> getAllYoungStudent()
    {
        return this.repository.findAll().stream().map(s->mapper.map(s,YoungStudent.class)).collect(Collectors.toList());
    }

    public YoungStudent insert(YoungStudent newStudent)
    {
        var pinfo=mapper.map(newStudent, YoungStudentEntity.class);
        pinfo.setId(null);
        pinfo=this.repository.saveAndFlush(pinfo);
        return mapper.map(pinfo, YoungStudent.class);
    }
}
