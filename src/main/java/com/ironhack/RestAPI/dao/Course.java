package com.ironhack.RestAPI.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @Column(name = "course_code")
    private String code;

    @Column(name = "course_name")
    private String name;
}
