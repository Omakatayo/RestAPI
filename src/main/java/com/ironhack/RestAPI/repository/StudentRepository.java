package com.ironhack.RestAPI.repository;

import com.ironhack.RestAPI.dao.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentByLastName(String lastName);
}
