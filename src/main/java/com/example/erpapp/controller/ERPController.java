package com.example.erpapp.controller;

import com.example.erpapp.dto.StudentPercentageDto;
import com.example.erpapp.module.Student;
import com.example.erpapp.service.ERPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ERPController {
    @Autowired
    ERPService erpService;

    //localhost:8080/api/v1/find-all-students
    @GetMapping("/find-all-students")
    public List<Student> findAll(){
        return erpService.getList();
    }

    //localhost:8080/api/v1/get-student/roll-no/id
    @GetMapping("/get-student/roll-no/{id}")
    public Student findStudent(@PathVariable int id){
        return erpService.getStudent(id);
    }

    //localhost:8080/api/v1/topper
     @GetMapping("/topper")
    public StudentPercentageDto findTopper(){
        List<StudentPercentageDto> list3=erpService.getPercentage();
        return erpService.getTopper(list3);
     }

     //localhost:8080/api/v1/lowest-percentage
    @GetMapping("/lowest-percentage")
    public StudentPercentageDto findLower(){
        List<StudentPercentageDto> list3=erpService.getPercentage();
        return erpService.getlowest(list3);
    }

    //localhost:8080/api/v1/all-percentage
     @GetMapping("/all-percentage")
    public List<StudentPercentageDto> percentage(){
        return erpService.getPercentage();
     }

     //localhost:8080/api/v1/add-student
     @PostMapping("/add-student")
    public void addStudents(@RequestBody Student student){
        erpService.addlist(student);
     }


     //localhost:8080/api/v1/update-student/roll-no/id
     @PutMapping("/update-student/roll-no/{id}")
    public void updateStudent(@PathVariable int id,@RequestBody Student student){
        erpService.update(id,student);
     }

     //localhost:8080/api/v1/delete-student/roll-no/id
     @DeleteMapping("/delete-student/roll-no/{id}")
    public void deleteStudent(@PathVariable  int id){
        erpService.delete(id);
     }

}
