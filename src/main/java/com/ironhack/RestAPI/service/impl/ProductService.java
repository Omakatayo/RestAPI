package com.ironhack.RestAPI.service.impl;

import com.ironhack.RestAPI.controller.dto.ProductDTO;
import com.ironhack.RestAPI.dao.Product;
import com.ironhack.RestAPI.enums.Category;
import com.ironhack.RestAPI.enums.Department;
import com.ironhack.RestAPI.repository.ProductRepository;
import com.ironhack.RestAPI.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Optional;

@Service // used to mark the class a a service provider / define set of avaliable methods
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    public void update(Long id, Product product) {
        Optional<Product> storedProduct = productRepository.findById(id);
        if (storedProduct.isPresent()) {
            product.setId(storedProduct.get().getId());  // set old id in new product
            productRepository.save(product);  // save new product with old id
        }
    }

    public void updatePrice(Long id, BigDecimal price) {
        Optional<Product> storedProduct = productRepository.findById(id);
        if (storedProduct.isPresent()) {
            storedProduct.get().setPrice(price);
            productRepository.save(storedProduct.get());
        }
    }

    public void updateCategory(Long id, Category category) {
        Optional<Product> storedProduct = productRepository.findById(id);
        if (storedProduct.isPresent()) {
            storedProduct.get().setCategory(category);
            productRepository.save(storedProduct.get());
        }
    }

    public void updateDepartment(Long id, Department department) {
        Optional<Product> storedProduct = productRepository.findById(id);
        if (storedProduct.isPresent()) {
            storedProduct.get().setDepartment(department);
            productRepository.save(storedProduct.get());
        }
    }

    public void updateName(Long id, String name) {
        Optional<Product> storedProduct = productRepository.findById(id);
        if (storedProduct.isPresent()) {
            storedProduct.get().setName(name);
            productRepository.save(storedProduct.get());
        }
    }

    public void updateAny(Long id, ProductDTO productDTO) {
        Optional<Product> storedProduct = productRepository.findById(id);
        if (storedProduct.isPresent()) {
            if (productDTO.getCategory() != null) {
                storedProduct.get().setCategory(productDTO.getCategory());
            }
            if (productDTO.getDepartment() != null) {
                storedProduct.get().setDepartment(productDTO.getDepartment());
            }
            if (productDTO.getName() != null) {
                storedProduct.get().setName(productDTO.getName());
            }
            if (productDTO.getPrice() != null) {
                storedProduct.get().setPrice(productDTO.getPrice());
            }
        }
    }
}
