package com.example.SpringMvc.repository;


import com.example.SpringMvc.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StudentDAO extends JpaRepository<Student,Long> {


}

