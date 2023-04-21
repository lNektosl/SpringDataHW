package com.example.test.entety.dto.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StudentRequest {
    private String name;
    private String surname;
    private int courseId;
}
