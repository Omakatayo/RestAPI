package com.ironhack.RestAPI.service.impl;

import com.ironhack.RestAPI.dao.Student;
import com.ironhack.RestAPI.repository.StudentRepository;
import com.ironhack.RestAPI.service.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void update(Long id, Student student) {
        Optional<Student> storedStudent = studentRepository.findById(id);
        if (storedStudent.isPresent()) {
            student.setId(storedStudent.get().getId());
            studentRepository.save(student);
        }
    }
}
