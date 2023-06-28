package com.students;

import com.students.entities.Course;
import com.students.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Jack", 1.0f);
        Student s2 = new Student(2, "Jill", 4.0f);

        Course course = new Course(1, "EA");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentService");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(s1);
        em.persist(s2);
        em.persist(course);

        course.addStudents(s1);
        course.addStudents(s2);

        em.persist(course);

        System.out.println("Student: " + s1.getName() + "Course: " + s1.getCourse());
        System.out.println("Student: " + s2.getName() + "Course: " + s2.getCourse());
        System.out.println("Course Students: " + course.getStudents());

        tx.commit();
        em.close();
        emf.close();
    }
}
