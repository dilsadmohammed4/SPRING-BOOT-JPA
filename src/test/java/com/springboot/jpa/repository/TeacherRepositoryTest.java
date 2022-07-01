package com.springboot.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.jpa.entities.Course;
import com.springboot.jpa.entities.Teacher;

@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course course1 = Course.builder()
                .title("Python")
                .credit("8")
                .build();
        Course course2 = Course.builder()
                .title("OS")
                .credit("5")
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Sivanand")
                .lastName("Sahoo")
                .courses(List.of(course1, course2))
                .build();

        teacherRepository.save(teacher);
    }
}
