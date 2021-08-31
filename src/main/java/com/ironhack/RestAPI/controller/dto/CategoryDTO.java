package com.ironhack.RestAPI.controller.dto;

import com.ironhack.RestAPI.enums.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class CategoryDTO {

    @Enumerated(EnumType.STRING)
    private Category category;
}
