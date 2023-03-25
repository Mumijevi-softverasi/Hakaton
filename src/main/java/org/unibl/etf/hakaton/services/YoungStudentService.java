package org.unibl.etf.hakaton.services;

import org.unibl.etf.hakaton.models.dto.YoungStudent;
import org.unibl.etf.hakaton.models.entities.YoungStudentEntity;

import java.util.List;

public interface YoungStudentService
{
    public List<YoungStudent> getAllYoungStudent();
    public YoungStudent insert(YoungStudent newStudent);
}
