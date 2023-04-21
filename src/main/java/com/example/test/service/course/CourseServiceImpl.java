package com.example.test.service.course;

import com.example.test.entety.Course;
import com.example.test.entety.Student;
import com.example.test.entety.dto.response.CourseResponse;
import com.example.test.repository.CourseRepository;
import com.example.test.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    @Override
    public Course getByID(int id) {
        return courseRepository.getById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public CourseResponse save(Course course) {
        courseRepository.save(course);
        return CourseResponse.builder()
                .courseId(course.getId())
                .name(course.getName())
                .students(course.getStudents())
                .build();
    }

    @Override
    public CourseResponse enroll(int studentId, int courseId) {
        Course course = courseRepository.findById(courseId).get();
        System.out.println(course.getName());
        Student student = studentRepository.findById(studentId).get();
        System.out.println(student.getName());
        course.getStudents().add(student);
        System.out.println(course.getStudents());
        courseRepository.save(course);
        return CourseResponse.builder()
                .courseId(course.getId())
                .name(course.getName())
                .students(course.getStudents())
                .build();
    }

    public String deleteById(int courseId) {
        String response = "course: " + courseRepository.findById(courseId).get().getName() + " got deleted";
        courseRepository.deleteById(courseId);
        return response;
    }
}
