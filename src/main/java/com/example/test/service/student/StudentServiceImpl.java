package com.example.test.service.student;

import com.example.test.entety.Student;
import com.example.test.entety.dto.request.StudentRequest;
import com.example.test.entety.dto.response.StudentResponse;
import com.example.test.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
private final StudentRepository studentRepository;
    @Override
    public Student getByID(int id) {return studentRepository.getById(id);}

    @Override
    public StudentResponse save(StudentRequest request) {
        studentRepository.save(Student.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .build());
        return StudentResponse.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .build();
    }
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public String deleteById(int student_id) {
        String response ="Student: " + studentRepository.findById(student_id).get().getName() + " got deleted";
        studentRepository.deleteById(student_id);
        return response;
    }

}
