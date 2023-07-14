package com.example.repository;

import com.example.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor {
    public List<Student> findStudentsByNameAndGpa(String name, float gpa);

    List<Student> findAllQualifiedForGraduation();

    List<Student> findByGpaEqualsOrderByGpaAsc(int gpa);


}
