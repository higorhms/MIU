package com.service;

import com.entities.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    public StudentService(){
        this.students.add(new Student("Jack", 3.0));
        this.students.add(new Student("John", 2.0));
        this.students.add(new Student("Jill", 3.8));
        this.students.add(new Student("Jim", 3.3));
        this.students.add(new Student("Jacob", 2.8));
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudent(int index){
        return students.get(index);
    }

    public Student findStudent(String name){
        return students.stream()
                .filter(student -> student.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
