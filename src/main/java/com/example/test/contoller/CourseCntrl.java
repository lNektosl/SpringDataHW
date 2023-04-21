package com.example.test.contoller;

import com.example.test.entety.Course;
import com.example.test.entety.dto.response.CourseResponse;
import com.example.test.service.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseCntrl {

    private final CourseService courseService;


    @GetMapping
    List<Course> allCourses(){
        return courseService.findAll();
    }

    @PostMapping
    CourseResponse addCourse(@RequestBody Course course){
       return courseService.save(course);
    }

    @PutMapping("/{courseId}/students/{studentId}")
    CourseResponse enrolStudentToCourse(@PathVariable Integer courseId, @PathVariable Integer studentId){
        return courseService.enroll(studentId,courseId);
    }
    @DeleteMapping("/{course_id}")
    String delete(@PathVariable int course_id){
        return courseService.deleteById(course_id);
    }
}
