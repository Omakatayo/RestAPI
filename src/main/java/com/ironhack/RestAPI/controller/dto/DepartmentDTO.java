package com.ironhack.RestAPI.controller.dto;

import com.ironhack.RestAPI.enums.Department;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class DepartmentDTO {

    @Enumerated(EnumType.STRING)
    private Department department;
}
