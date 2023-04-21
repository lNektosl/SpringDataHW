package com.example.test.entety.dto.response;

import com.example.test.entety.Student;
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
