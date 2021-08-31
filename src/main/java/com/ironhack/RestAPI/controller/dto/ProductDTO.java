package com.ironhack.RestAPI.controller.dto;

import com.ironhack.RestAPI.enums.Category;
import com.ironhack.RestAPI.enums.Department;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO {

    private Category category;
    private Department department;
    private String name;
    private BigDecimal price;

}
