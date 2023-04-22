package com.example.test.contoller;

import com.example.test.entity.Student;
import com.example.test.entity.dto.request.StudentRequest;
import com.example.test.entity.dto.response.StudentResponse;
import com.example.test.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;


    @GetMapping
    public List<Student> allStudents() {
        return studentService.findAll();
    }

    @PostMapping
    public StudentResponse addStudent(@RequestBody StudentRequest request) {
        return studentService.save(request);

    }
    @DeleteMapping("/{student_id}")
    public String delete(@PathVariable int student_id){
        return studentService.deleteById(student_id);
    }
}
