package com.example.test.entity.dto.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GradeRequest {
    private int value;
    private int student;
    private int course;
}
