package com.springboot.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.jpa.entities.Guardian;
import com.springboot.jpa.entities.Student;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("dilsadmohammed4@gmail.com")
                .firstName("Dilsad")
                .lastName("Mohammed")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Dilsad Mohamed")
                .email("dilsad@gmail.in")
                .mobile("6785369878")
                .build();

        Student student = Student.builder()
                .firstName("Anmol")
                .lastName("Singh")
                .emailId("Anmol@yahoo.in")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList" + studentList);

    }

    @Test
    public void printStudentByFirstName() {
        List<Student> student1 = studentRepository.findByFirstName("Himanshu");
        System.out.println("**********PrintStudentByFirstName************");
        System.out.println(student1);
    }

    @Test
    public void printStudentByFirstNamecontain() {
        List<Student> student2 = studentRepository.findByFirstNameContaining("Hi");
        System.out.println("**********PrintStudentByFirstNamecontain************");
        System.out.println(student2);
    }

    @Test
    public void printStudentByGuardianName() {
        List<Student> student3 = studentRepository.findByGuardianName("Dilsad Mohamed");
        System.out.println("**********PrintStudentByGuardianName************");
        System.out.println(student3);
    }

    @Test
    public void printStudentByFirstNameAndLastName() {
        List<Student> student4 = studentRepository.findByFirstNameAndLastName("Himanshu", "Singh");
        System.out.println("**********PrintStudentByFirstNameAndLastName************");
        System.out.println(student4);
    }

    // JPQL QUERY
    @Test
    public void printStudentByEmailAdress() {
        Student student5 = studentRepository.findStudentByEmailAddress("Anmol@yahoo.in");
        System.out.println("**********PrintStudentByEmailAdress************");
        System.out.println(student5);
    }

    @Test
    public void printFirstNameStudentByEmailAdress() {
        String student6 = studentRepository.findStudentFirstNameByEmailAddress("Anmol@yahoo.in");
        System.out.println("**********PrintFirstNameStudentByEmailAdress************");
        System.out.println(student6);
    }

    // NATIVE QUERY
    @Test
    public void printStudentByEmailAdressNative() {
        Student student7 = studentRepository.findStudentByEmailAddressNative("Anmol@yahoo.in");
        System.out.println("**********PrintStudentByEmailAdressNative************");
        System.out.println(student7);
    }

    // NATIVE QUERY Param
    @Test
    public void printStudentByEmailAdressNativeParam() {
        Student student8 = studentRepository.findStudentByEmailAddressNativeNameParam("Anmol@yahoo.in");
        System.out.println("**********PrintStudentByEmailAdressNativeParam************");
        System.out.println(student8);
    }

    @Test
    public void updateStudentByEmailAdressNativeParam() {
        int student = studentRepository.updateStudentNameByEmailId("Anmol", "Anmol@yahoo.in");
        System.out.println("**********PrintStudentByEmailAdressNativeParam************");
        System.out.println(student + " Updated.......");
    }
}
