package com.ironhack.RestAPI.controller.interfaces;

import com.ironhack.RestAPI.dao.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseController {
    String helloWorld();
    List<Course> getCourses();
    Course getByName(String courseName);
    List<Course> getCourseByName(Optional<String> name);  // make use of @RequestParams
}
