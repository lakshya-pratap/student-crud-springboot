package com.example.mulesoft_submission.DAO;

import com.example.mulesoft_submission.Entity.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentDAO extends JpaRepository<Student,Long> {
    @Query("select s from Student s where s.name = ?1")
    public Student findStudentbyName(String name);
}
