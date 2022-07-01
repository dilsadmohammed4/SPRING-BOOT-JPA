package com.springboot.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.jpa.entities.Course;
import com.springboot.jpa.entities.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {

        Course course = Course.builder()
                .title("C++")
                .credit("6")
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.in")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {

        List<CourseMaterial> courseMaterial = courseMaterialRepository.findAll();
        System.out.println("Course Materials: " + courseMaterial);
    }
}
