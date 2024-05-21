package com.hutech.javas3d3.Services;

import com.hutech.javas3d3.Entities.Student;
import com.hutech.javas3d3.Repositories.StudentRepository;
import com.hutech.javas3d3.RequestEntities.StudentCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentServices {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }
    public Student createStudent(StudentCreate studentCreate){
       try{
           Student student = new Student();
           student.setFirstName(studentCreate.getFirstName());
           student.setLastName(studentCreate.getLastName());
           student.setEmail(studentCreate.getEmail());
           student.setPassword(studentCreate.getPassword());
           DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
           student.setDateOfBirth(dateFormat.parse(studentCreate.getDateOfBirth()));
           student.setAge((new Date()).getYear()-student.getDateOfBirth().getYear());
           studentRepository.save(student);
           return student;
       }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
       }
    }
}
