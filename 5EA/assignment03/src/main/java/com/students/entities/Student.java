package com.students.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "CanGraduate",
        query = "SELECT S FROM Student S WHERE S.gpa >= 3 AND SIZE(S.coursesAttended) >= 9 AND S.courseAttending IS NULL")
})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private Float gpa;

    @ManyToOne
    private Course courseAttending;

    @ManyToMany
    private List<Course> coursesAttended = new ArrayList<>();

    public Student(String name, Float gpa) {
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


    public Course getCourseAttending() {
        return courseAttending;
    }

    public void setCourseAttending(Course courseAttending) {
        this.courseAttending = courseAttending;
    }

    public List<Course> getCoursesAttended() {
        return coursesAttended;
    }

    public void setCoursesAttended(List<Course> coursesAttended) {
        this.coursesAttended = coursesAttended;
    }

    public void addCourseAttended(Course course){
        this.coursesAttended.add(course);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
