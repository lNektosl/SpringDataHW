package com.example.test.entety;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "student_id")
    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<Student> students;
}
