package com.hutech.javas3d3.Controllers;

import com.hutech.javas3d3.Entities.Student;
import com.hutech.javas3d3.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentServices studentServices;
    @GetMapping("")
    public String getAllStudent(Model model){
        List<Student> students = studentServices.getAllStudent();
        model.addAttribute("students", students);
        return "Student/getAll";
    }
}
