package com.ironhack.RestAPI.service.interfaces;

import com.ironhack.RestAPI.dao.Student;

public interface IStudentService {
    void update(Long id, Student student);
}
