package com.miu.compro.services;

import com.miu.compro.repository.StudentSpecification;
import com.miu.compro.entities.Student;
import com.miu.compro.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentsService {
    private StudentRepository studentsRepository;

    @Autowired
    public StudentsService(StudentRepository studentsRepository){
        this.studentsRepository = studentsRepository;
    }

    public List<Student> getAll(){
        return this.studentsRepository.findAll();
    }

    public List<Student> getAllWithCriteria(int gpa){
        return this.studentsRepository.findAll(StudentSpecification.hasGpaGreaterThan(gpa));
    }

    public List<Student> getByGPA(int gpa) {
        return studentsRepository.findByGpaEqualsOrderByGpaAsc(gpa);
    }

    public List<Student> getQualifiedForGraduation() {
        return studentsRepository.findAllQualifiedForGraduation();
    }

    public List<Student> findAllStudentsWithGpaLessThanAndHaveABookWithMoreThanPages(int gpa, int pages){
        return this.studentsRepository.findAll(StudentSpecification.findAllStudentsWithGpaLessThanAndHaveABookWithMoreThanPages(gpa, pages));
    }
}
