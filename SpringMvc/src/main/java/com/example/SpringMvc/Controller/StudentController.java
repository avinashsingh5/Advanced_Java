package com.example.SpringMvc.Controller;

import com.example.SpringMvc.Service.StudentService;
import com.example.SpringMvc.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String showRegisterPage() {
        return "Register";
    }

    @PostMapping("/register")
    public String registerStudent(@ModelAttribute Student student, Model model) {

        studentService.saveStudent(student);

        model.addAttribute("name", student.getName());
        return "Success";
    }
}