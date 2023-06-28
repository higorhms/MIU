package com.students.entities;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    private int id;

    private String name;

    private Float gpa;

    @ManyToOne
//    @JoinColumn
    private Course course;

    public Student(int id, String name, Float gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public Student() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
