package com.example.test.contoller;

import com.example.test.entety.Grade;
import com.example.test.entety.dto.request.GradeRequest;
import com.example.test.entety.dto.response.GradeResponse;
import com.example.test.service.grade.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grade")
@RequiredArgsConstructor
public class GradeCntrl {
    private final GradeService gradeService;


    @GetMapping
    public List<Grade> allGrades() {
        return gradeService.findAll();
    }
    @PostMapping
    public GradeResponse save(@RequestBody GradeRequest request){
        return gradeService.add(request);
    }

    @DeleteMapping("/{grade_id}")
    public String deleteById(@PathVariable(value = "grade_id") int id) {
        return gradeService.delete(id);
    }
}
