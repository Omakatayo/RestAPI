package com.ironhack.RestAPI.repository;

import com.ironhack.RestAPI.dao.Product;
import com.ironhack.RestAPI.enums.Category;
import com.ironhack.RestAPI.enums.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryAndDepartment(Category category, Department department);

    List<Product> findByDepartment(Department department);
}
