package com.ironhack.RestAPI.repository;

import com.ironhack.RestAPI.dao.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    Optional<Course> findByName(String name);

    List<Course> findCourseByName(String name);
}
