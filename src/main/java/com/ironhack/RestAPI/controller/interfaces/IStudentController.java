package com.ironhack.RestAPI.controller.interfaces;

import com.ironhack.RestAPI.dao.Course;
import com.ironhack.RestAPI.dao.Product;
import com.ironhack.RestAPI.dao.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentController {
    Student getById(long studentId);   // makes use of @path variable
    List<Student> getStudentByLastName(Optional<String> lastName);  // make use of @RequestParams
}
