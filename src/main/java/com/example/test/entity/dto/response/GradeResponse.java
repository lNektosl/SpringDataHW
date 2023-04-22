package com.example.test.entity.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GradeResponse {
    private int value;
    private int studentId;
    private int courseID;
}
