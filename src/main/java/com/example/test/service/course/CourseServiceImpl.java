package com.example.test.service.course;

import com.example.test.entity.Course;
import com.example.test.entity.Student;
import com.example.test.entity.dto.response.CourseResponse;
import com.example.test.repository.CourseRepository;
import com.example.test.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final StudentService studentService;

    @Override
    public Course getByID(int id) {
        return courseRepository.findById(id).get();
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
    public CourseResponse enroll(int courseId, int studentId) {
        Course course = courseRepository.findById(courseId).get();
        Student student = studentService.getByID(studentId);
        course.getStudents().add(student);
        student.getCourses().add(course);
        studentService.change(student);
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
