package com.example.test.service.grade;

import com.example.test.entety.Grade;
import com.example.test.entety.dto.request.GradeRequest;
import com.example.test.entety.dto.response.GradeResponse;
import com.example.test.repository.GradeRepository;
import com.example.test.service.course.CourseService;
import com.example.test.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {
    private final GradeRepository gradeRepository;
    private final StudentService studentService;
    private final CourseService courseService;


    @Override
    public String delete(int id) {
        String response = "Grade: " + gradeRepository.getById(id) + " got deleted";
        gradeRepository.deleteById(id);
        return response;
    }

    public GradeResponse add(GradeRequest request) {
        Grade grade = Grade.builder()
                .value(request.getValue())
                .student(studentService.getByID(request.getStudent()))
                .course(courseService.getByID(request.getCourse()))
                .build();
        gradeRepository.save(grade);
        return GradeResponse.builder()
                .value(request.getValue())
                .studentId(request.getStudent())
                .courseID(request.getCourse())
                .build();
    }
    @Override
    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }
}
