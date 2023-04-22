package com.example.test.service.course;

import com.example.test.entity.Course;
import com.example.test.entity.dto.response.CourseResponse;

import java.util.List;

public interface CourseService {
    Course getByID(int id);

    List<Course> findAll();

    CourseResponse save(Course course);

    CourseResponse enroll(int studentId, int courseId);

    String deleteById(int courseId);
}
