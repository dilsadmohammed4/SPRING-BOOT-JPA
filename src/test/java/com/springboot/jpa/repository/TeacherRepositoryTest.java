package com.springboot.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.jpa.entities.Course;
import com.springboot.jpa.entities.Teacher;

@SpringBootTest
public class TeacherRepositoryTest {

        @Autowired
        private CourseRepository courseRepository;

        @Test
        public void saveCourseWithTeacher() {

                Teacher teacher = Teacher.builder()
                                .firstName("Rabindra")
                                .lastName("Barik")
                                .build();
                Course course = Course.builder()
                                .title("DS")
                                .credit("7")
                                .teacher(teacher)
                                .build();

                courseRepository.save(course);
        }

}
