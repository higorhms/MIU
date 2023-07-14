package com.miu.compro.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQuery(name = "Student.findAllQualifiedForGraduation", query = "SELECT s FROM Student s WHERE s.gpa >= 30 AND s.courseCount >= 9")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int gpa;

    private Integer courseCount;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> books;


    public Student(String name, int gpa, int courseCount) {
        this.name = name;
        this.gpa = gpa;
        this.courseCount = courseCount;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

}
