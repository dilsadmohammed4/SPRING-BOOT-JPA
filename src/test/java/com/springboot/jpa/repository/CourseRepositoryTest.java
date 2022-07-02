package com.springboot.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.springboot.jpa.entities.Course;

@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void PrintCourses() {
        List<Course> course = courseRepository.findAll();
        System.out.println("Courses:" + course);
    }

    @Test
    public void findAllPagination() {
        PageRequest firstPageWithThreeRecords = PageRequest.of(0, 3);
        PageRequest secondPageWithThreeRecords = PageRequest.of(1, 2);
        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        Long totalElement = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        int totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();
        System.out.println("+=========================+");
        System.out.println(courses);
        System.out.println("courses element:" + totalElement);
        System.out.println("courses pages:" + totalPages);
    }

    @Test
    public void findAllSort() {
        PageRequest sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        PageRequest sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
        PageRequest sortByTitleAndCreditDesc = PageRequest.of(0, 2,
                Sort.by("title").descending().and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("======title===========");
        System.out.println(courses);
    }

    @Test
    public void printfindByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);
        System.out.println("+++++++++++++++++++++++PrintfindByTitleContaining+++++++++++++++++++");

        List<Course> courses = courseRepository.findByTitleContaining(
                "D",
                firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }
}
