package com.ironhack.RestAPI.service.interfaces;

import com.ironhack.RestAPI.controller.dto.ProductDTO;
import com.ironhack.RestAPI.dao.Product;
import com.ironhack.RestAPI.enums.Category;
import com.ironhack.RestAPI.enums.Department;

import java.math.BigDecimal;
import java.util.Optional;

public interface IProductService {

    void update(Long id, Product product);

    void updatePrice(Long id, BigDecimal price);

    void updateCategory(Long id, Category category);

    void updateDepartment(Long id, Department department);

    void updateName(Long id, String name);

    public void updateAny(Long id, ProductDTO productDTO);

    //void updateAny(Long id, Optional<Category> category, Optional<Department> department, Optional<String> name, Optional<BigDecimal> price);

}
