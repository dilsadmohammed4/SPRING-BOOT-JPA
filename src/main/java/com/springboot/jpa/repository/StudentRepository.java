package com.springboot.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.jpa.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    public List<Student> findByFirstNameContaining(String firstName);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String guardianName);

    // JPQL QUERY(USING CLASS NAME AND ATTRIBUTE)
    @Query("select s from Student s where s.emailId=?1")
    Student findStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId=?1")
    String findStudentFirstNameByEmailAddress(String emailId);

    // Native SQL QUERY
    @Query(value = "select * from student s where s.email_id=?1", nativeQuery = true)
    Student findStudentByEmailAddressNativeNameParam(String emailId);

    // Native SQL QUERY Param
    @Query(value = "select * from student s where s.email_id=:email", nativeQuery = true)
    Student findStudentByEmailAddressNative(@Param("email") String emailId);

    @Modifying
    @Transactional
    @Query(value = "update student set first_name= :fName where email_id=:email", nativeQuery = true)
    int updateStudentNameByEmailId(@Param("fName") String firstName, @Param("email") String emailId);
}
