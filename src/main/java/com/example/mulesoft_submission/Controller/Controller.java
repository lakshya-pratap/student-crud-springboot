package com.example.mulesoft_submission.Controller;

import com.example.mulesoft_submission.Entity.Student;
import com.example.mulesoft_submission.Service.StudentService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@RequestMapping("api/v1")
public class Controller {
    private final StudentService studentService;

    @GetMapping("/getById")
    public ResponseEntity<Student> getStudent(@RequestParam("id") Long id) {
        return new ResponseEntity<>(studentService.getStudentbyId(id), HttpStatus.OK);
    }
    @GetMapping("/getByName")
    public ResponseEntity<Student> getStudent(@RequestParam("name") String name) {
        return new ResponseEntity<>(studentService.getStudentbyName(name), HttpStatus.OK);
    }
    @PutMapping("/create")
    public ResponseEntity<Void> createStudent(@RequestParam("id") Long id, @RequestParam("name") String name,@RequestParam("email") String email, @RequestParam("age") Integer age, @RequestParam("phone") String phone) {
        studentService.createStudent(id,name,email,age,phone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Boolean> updateStudent(@RequestParam("id") Long id, @RequestParam("name") String name,@RequestParam("email") String email, @RequestParam("age") Integer age, @RequestParam("phone") String phone) {
        return new ResponseEntity<>(studentService.updateStudent(id,name,email,age,phone),HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteStudent(@RequestParam("id") Long id) {
        return new ResponseEntity<>(studentService.deleteStudent(id),HttpStatus.OK);
    }




}
