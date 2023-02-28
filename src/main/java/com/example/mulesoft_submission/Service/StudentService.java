package com.example.mulesoft_submission.Service;

import com.example.mulesoft_submission.DAO.StudentDAO;
import com.example.mulesoft_submission.Entity.Student;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class StudentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    private  StudentDAO studentDAO;

    //create
    public void createStudent(Long id, String name, String email, Integer age, String phone) {
        Student student = new Student(id,name,email,age,phone);
        studentDAO.saveAndFlush(student);
        LOGGER.info("created a new student");
    }
    //read
    public Student getStudentbyId(Long id) {
        Student student = studentDAO.getReferenceById(id);
        if(student == null) LOGGER.error("student does not exist with id: " + id);
        return student;
    }
    public Student getStudentbyName(String name) {
        Student student = studentDAO.findStudentbyName(name);
        return student;
    }
    //update
    public boolean updateStudent(Long id, String name,String email, Integer age, String phone) {
        Student student = studentDAO.getReferenceById(id);
        if(student == null) {
            LOGGER.error("student does not exist for the given id");
            return false;
        }
        if(name != null)
            student.setName(name);
        if(email != null)
            student.setEmail(email);
        if(age != null)
            student.setAge(age);
        if(phone != null)
            student.setPhone(phone);
        studentDAO.saveAndFlush(student);
        LOGGER.info("updated the student with id: " + student.getId());
        return true;
    }
    //delete
    public boolean deleteStudent(Long id) {
        Student student = studentDAO.getReferenceById(id);
        if(student == null) {
            LOGGER.error("student does not exist for the given id");
            return false;
        }
        studentDAO.delete(student);
        LOGGER.info("deleted student with id :" + id);
        return true;

    }
}
