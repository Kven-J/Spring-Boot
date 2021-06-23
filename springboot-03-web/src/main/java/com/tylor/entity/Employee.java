package com.tylor.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private Integer sex; //"0":女  "1":男
    private Date birth;
    private Department department;

    public Employee(Integer id, String lastName, String email, Integer sex, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.sex = sex;
        this.birth = new Date();
        this.department = department;
    }
}
