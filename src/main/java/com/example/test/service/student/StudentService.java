package com.example.test.service.student;

import com.example.test.entety.Student;
import com.example.test.entety.dto.request.StudentRequest;
import com.example.test.entety.dto.response.StudentResponse;

import java.util.List;


public interface StudentService {
    Student getByID(int id);

    StudentResponse save(StudentRequest request);

    List<Student> findAll();

    String deleteById(int student_id);
}
