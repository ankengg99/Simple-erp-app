package com.example.erpapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StudentPercentageDto {
    private String name;
    private int rollno;
    private double percentage;
   public StudentPercentageDto(){

    }
}
