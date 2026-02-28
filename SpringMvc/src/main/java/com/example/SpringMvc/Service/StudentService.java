package com.example.SpringMvc.Service;

import com.example.SpringMvc.model.Student;
import com.example.SpringMvc.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentDAO studentdao;   // variable name required

    public void saveStudent(Student student){
        studentdao.save(student);  // call object
    }
}