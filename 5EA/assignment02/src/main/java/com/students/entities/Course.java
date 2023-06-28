package com.students.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    private int id;

    private String title;

    private int capacity;

    @OneToMany(mappedBy = "course")
    private List<Student> students;

    public Course(){}

    public Course(int id, String title) {
        this.id = id;
        this.title = title;
        this.capacity = 10;
        this.students = new ArrayList<Student>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return this.title;
    }

    public void addStudents(Student s){
        s.setCourse(this);
        this.students.add(s);
    }
}
