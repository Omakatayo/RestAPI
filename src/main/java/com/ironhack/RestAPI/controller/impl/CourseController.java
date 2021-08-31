package com.ironhack.RestAPI.controller.impl;

import com.ironhack.RestAPI.controller.interfaces.ICourseController;
import com.ironhack.RestAPI.dao.Course;
import com.ironhack.RestAPI.dao.Product;
import com.ironhack.RestAPI.enums.Category;
import com.ironhack.RestAPI.enums.Department;
import com.ironhack.RestAPI.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseController implements ICourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/hello-world") // this manages a specific route
    @ResponseStatus(HttpStatus.OK) // this manages the status code
    public String helloWorld() {
        return "Hello world!! Welcome Rest API!!";
    }

    @GetMapping("/courses")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCourses() {

        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course("MA103", "College Algebra"));
        courseList.add(new Course("MA102", "Calculus 1"));

        Course course = new Course("CS100", "Math course");
        courseRepository.save(course);

        //return courseList;
        return courseRepository.findAll();
    }

    @GetMapping("/course/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Course getByName(@PathVariable(name = "name") String courseName) {
        Optional<Course> optionalCourse = courseRepository.findByName(courseName);

        return optionalCourse.orElse(null); // optionalCourse.isPresent() ? optionalCourse.get() : null;
    }

    @GetMapping("/course")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCourseByName(@RequestParam Optional<String> name) {

        if (name.isPresent()) {
            return courseRepository.findCourseByName(name.get());
        }
        else {
            return courseRepository.findAll();
        }
    }
}
