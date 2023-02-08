package com.example.erpapp.service;


import com.example.erpapp.dto.StudentPercentageDto;
import com.example.erpapp.module.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ERPService {
    private static final List<Student> list=new ArrayList<>();
    private static List<StudentPercentageDto> list2=new ArrayList<>();
    static {
        list.add(new Student(1,"sonu",List.of(80.0,75.0,90.0,70.0),"delhi","M"));
        list.add(new Student(2,"anu",List.of(85.0,75.0,50.0,60.0),"patna","F"));
        list.add(new Student(3,"arpita",List.of(60.0,55.0,30.0,75.0),"lucknow","F"));
        list.add(new Student(4,"shubham",List.of(90.0,95.0,90.0,20.0),"kolkata","M"));
    }
          public List<Student> getList(){
        return list;
          }
          public Student getStudent(int id){
             for(Student student:list){
                 if(student.getRollno()==id){
                     return student;
                 }
             }
             return null;
          }
          public StudentPercentageDto getTopper(List<StudentPercentageDto> list){
              double max=0.0;
              StudentPercentageDto temp=new StudentPercentageDto();
              for(StudentPercentageDto s:list){
                  if(s.getPercentage()>max){
                      temp=s;
                      max=s.getPercentage();
                  }
              }
              return temp;
          }
    public StudentPercentageDto getlowest(List<StudentPercentageDto> list){
        double min=Double.MAX_VALUE;
        StudentPercentageDto temp=new StudentPercentageDto();
        for(StudentPercentageDto s:list){
            if(s.getPercentage()<min){
                temp=s;
                min=s.getPercentage();
            }
        }
        return temp;
    }
          public List<StudentPercentageDto> getPercentage(){
              for(Student student:list){
                  List<Double> temp=student.getMarks();
                  double perc=0.0;
                  for (double marks: temp ){
                      perc=perc+marks;
                  }
                  perc=perc*.25;
                  list2.add(new StudentPercentageDto(student.getName(),student.getRollno(),perc));
              }
              return list2;
          }
          public void addlist(Student student){
            list.add(student);
          }
          public void update(int rollno,Student student){
          Student s=new Student();
             for(Student str:list){
                 if(str.getRollno()==rollno){
                     s=str;
                     break;
                 }
             }
             s.setCity(student.getCity());
             s.setMarks(student.getMarks());
             s.setGender(student.getGender());
             s.setRollno(student.getRollno());
             s.setName(student.getName());
          }
          public void delete(int id){
        int idx=-1;
          for(int i=0; i<list.size(); i++){
              if(list.get(i).getRollno()==id){
                  idx=i;
                  break;
              }
          }
          list.remove(idx);
          }
}
