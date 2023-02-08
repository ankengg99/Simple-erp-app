package com.example.erpapp.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Data
public class Student {
    private int rollno;
    private String name;
    private List<Double> marks;
    private String city;
    private String gender;
      public Student(){}

}
