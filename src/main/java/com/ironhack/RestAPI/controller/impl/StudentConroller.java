package com.ironhack.RestAPI.controller.impl;

import com.ironhack.RestAPI.controller.interfaces.IStudentController;
import com.ironhack.RestAPI.dao.Student;
import com.ironhack.RestAPI.repository.StudentRepository;
import com.ironhack.RestAPI.service.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentConroller implements IStudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private IStudentService studentService;

    @GetMapping("/students/{id}")  // uniform resource identifier
    @ResponseStatus(HttpStatus.OK)
    public Student getById(@PathVariable(name = "id") long studentId) {
        Optional<Student> optionalStudentId = studentRepository.findById(studentId);

        return optionalStudentId.orElse(null); // optionalProduct.isPresent() ? optionalProduct.get() : null;
    }

    @GetMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getStudentByLastName(@RequestParam Optional<String> lastName) {

        if (lastName.isPresent()) {
            return studentRepository.findStudentByLastName(lastName.get().toUpperCase());
        }
        else {
            return studentRepository.findAll();
        }
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student store(@RequestBody @Valid Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable(name = "id") Long id, @RequestBody @Valid Student student) {
        studentService.update(id, student);
    }
}
