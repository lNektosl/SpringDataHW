package com.example.test.service.grade;

import com.example.test.entity.Grade;
import com.example.test.entity.dto.request.GradeRequest;
import com.example.test.entity.dto.response.GradeResponse;

import java.util.List;

public interface GradeService {
    String delete(int id);
    GradeResponse add(GradeRequest request);
    List<Grade> findAll();
}
