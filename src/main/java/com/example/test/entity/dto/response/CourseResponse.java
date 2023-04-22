package com.example.test.entity.dto.response;

import com.example.test.entity.Student;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CourseResponse {
private int courseId;
private String name;
private List<Student> students;
}
