package com.example.test.service.grade;

import com.example.test.entety.Grade;
import com.example.test.entety.dto.request.GradeRequest;
import com.example.test.entety.dto.response.GradeResponse;

import java.util.List;

public interface GradeService {
    String delete(int id);
    GradeResponse add(GradeRequest request);
    List<Grade> findAll();
}
