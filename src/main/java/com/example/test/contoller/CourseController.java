package com.example.test.contoller;

import com.example.test.entity.Course;
import com.example.test.entity.dto.response.CourseResponse;
import com.example.test.service.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;


    @GetMapping
    List<Course> allCourses(){
        return courseService.findAll();
    }

    @PostMapping
    CourseResponse addCourse(@RequestBody Course course){
       return courseService.save(course);
    }

    @PostMapping("/{courseId}/students/{studentId}")
    CourseResponse enrolStudentToCourse(@PathVariable Integer courseId, @PathVariable Integer studentId){
        return courseService.enroll(courseId,studentId);
    }
    @DeleteMapping("/{course_id}")
    String delete(@PathVariable int course_id){
        return courseService.deleteById(course_id);
    }
}
