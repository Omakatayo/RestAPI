package com.ironhack.RestAPI.controller.interfaces;

import com.ironhack.RestAPI.dao.Product;

import java.util.List;
import java.util.Optional;

public interface IProductController {
    Product getById(long productId);   // makes use of @path variable

    List<Product> getProductsByCategoryAndDepartment(Optional<String> category, String department);  // make use of @RequestParams
}
