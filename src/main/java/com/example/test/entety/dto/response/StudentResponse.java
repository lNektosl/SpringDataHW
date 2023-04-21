package com.example.test.entety.dto.response;

import com.example.test.entety.Course;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class StudentResponse {
    private String name;
    private String surname;
    private List<Course> courses;
}
