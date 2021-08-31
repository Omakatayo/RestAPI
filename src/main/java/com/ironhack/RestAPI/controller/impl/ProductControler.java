package com.ironhack.RestAPI.controller.impl;

import com.ironhack.RestAPI.controller.dto.*;
import com.ironhack.RestAPI.controller.interfaces.IProductController;
import com.ironhack.RestAPI.dao.Product;
import com.ironhack.RestAPI.enums.Category;
import com.ironhack.RestAPI.enums.Department;
import com.ironhack.RestAPI.repository.ProductRepository;
import com.ironhack.RestAPI.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductControler implements IProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private IProductService productService;

    @GetMapping("/products/{id}")  // uniform resource identifier
    @ResponseStatus(HttpStatus.OK)
    public Product getById(@PathVariable(name = "id") long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        return optionalProduct.orElse(null); // optionalProduct.isPresent() ? optionalProduct.get() : null;
    }

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProductsByCategoryAndDepartment(@RequestParam Optional<String> category, @RequestParam(defaultValue = "clothing") String department) {

        if (category.isPresent()) {
            return productRepository.findByCategoryAndDepartment(Category.valueOf(category.get().toUpperCase()), Department.valueOf(department.toUpperCase()));
        }
        else if (category.isEmpty()){
            return productRepository.findByDepartment(Department.valueOf(department.toUpperCase()));
        }
        else {
            return productRepository.findAll();
        }
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product store(@RequestBody @Valid Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable(name = "id") Long id, @RequestBody @Valid Product product) {
        productService.update(id, product);
    }

    /*@PatchMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePrice(@PathVariable(name = "id") Long id,
                            @RequestBody @Valid PriceDTO priceDTO) {
        productService.updatePrice(id, priceDTO.getPrice());
    }*/

    /*@PatchMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCategory(@PathVariable(name = "id") Long id,
                            @RequestBody @Valid CategoryDTO categoryDTO) {
        productService.updateCategory(id, categoryDTO.getCategory());
    }*/

    @PatchMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAny(@PathVariable(name = "id") Long id,
                            @RequestBody @Valid Optional<ProductDTO> productDTO) {
        if (productDTO.isPresent()) {
            if (productDTO.get().getCategory() != null) {
                productService.updateCategory(id, productDTO.get().getCategory());
            }
            if (productDTO.get().getDepartment() != null) {
                productService.updateDepartment(id, productDTO.get().getDepartment());
            }
            if (productDTO.get().getName() != null) {
                productService.updateName(id, productDTO.get().getName());
            }
            if (productDTO.get().getPrice() != null) {
                productService.updatePrice(id, productDTO.get().getPrice());
            }
        }
    }

    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
