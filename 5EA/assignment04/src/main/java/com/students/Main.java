package com.students;

import com.students.entities.Course;
import com.students.entities.DistanceEducation;
import com.students.entities.OnCampus;
import com.students.entities.Student;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Jack", 3.6f);
        Student s2 = new Student("Jill", 4.0f);
        Student s3 = new Student("Higor", 4.0f);
        Student s4 = new Student("Mario", 2.8f);

        Course asd = new OnCampus("ASD", new Date(), "Rene", "219", 40);
        Course mpp = new OnCampus("MPP", new Date(), "Asaad", "219", 40);
        Course fpp = new OnCampus("FPP", new Date(), "Asaad Saad", "219", 40);
        Course wap = new OnCampus("WAP", new Date(), "Bruce Lester", "219", 40);
        Course waa = new DistanceEducation("WAA", new Date(), "idk", "Rene");
        Course ea = new DistanceEducation("EA", new Date(), "Najeeb", "Najeeb");
        Course idk1 = new DistanceEducation("IDK1", new Date(), "IDK1", "IDK1");
        Course idk2 = new DistanceEducation("IDK2", new Date(), "IDK2", "IDK2");
        Course idk3 = new DistanceEducation("IDK3", new Date(), "IDK3", "IDK3");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentService");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(s1);
        em.persist(s2);
        em.persist(ea);
        em.persist(asd);
        em.persist(waa);
        em.persist(mpp);
        em.persist(fpp);
        em.persist(wap);
        em.persist(idk1);
        em.persist(idk2);
        em.persist(idk3);
        em.persist(s3);
        em.persist(s4);

        s1.addCourseAttended(asd);
        s1.addCourseAttended(waa);
        s1.setCourseAttending(ea);
        s2.setCourseAttending(asd);

        s3.addCourseAttended(fpp);
        s3.addCourseAttended(mpp);
        s3.addCourseAttended(wap);
        s3.addCourseAttended(waa);
        s3.addCourseAttended(ea);
        s3.addCourseAttended(idk1);
        s3.addCourseAttended(idk2);
        s3.addCourseAttended(idk3);
        s3.addCourseAttended(asd);

        s4.setCourseAttending(ea);

        tx.commit();



        //---------------------------------------------------------------------------------------------------------------



        //JPQL: find the students with GPA greater than 3.5 and attending a course with capacity > 30
        System.out.println("\nFind the students with GPA greater than 3.5 and attending a course with capacity > 30");

        TypedQuery<Student> query = em.createQuery(
                "SELECT s FROM Student s JOIN OnCampus c ON s.courseAttending = c WHERE s.gpa > 3.5 AND c.capacity > 30",
                Student.class
        );

        List<Student> resultList = query.getResultList();

        System.out.println(resultList);




        //---------------------------------------------------------------------------------------------------------------




        //NamedQuery: create a query called CanGraduate: this query returns all students that have a GPA greater than or equal to 3.0 and have taken at least 9 courses and are not enrolled in a course right now.
        System.out.println("\nCreate a query called CanGraduate: this query returns all students that have a GPA greater than or equal to 3.0 and have taken at least 9 courses and are not enrolled in a course right now.");
        Query canGraduate = em.createNamedQuery("CanGraduate");
        tx.begin();
        List resultList1 = canGraduate.getResultList();
        tx.commit();
        System.out.println(resultList1);





        //---------------------------------------------------------------------------------------------------------------





        //CriteriaAPI: find all students with GPA less than 3.0 and attending a DE course with "Najeeb"
        System.out.println("\nCriteriaAPI: find all students with GPA less than 3.0 and attending a DE course with 'Najeeb'");

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Student> studentCriteriaQuery = criteriaBuilder.createQuery(Student.class);

        Root<Student> studentRoot = studentCriteriaQuery.from(Student.class);

        Predicate gpaPredicate = criteriaBuilder.lessThan(studentRoot.get("gpa"), 3);
        Join<Object, Object> courseJoin = studentRoot.join("courseAttending", JoinType.INNER);
        Predicate professorNamePredicate = criteriaBuilder.equal(courseJoin.get("professorName"), "Najeeb");
        Predicate courseTypePredicate = criteriaBuilder.equal(courseJoin.type(), DistanceEducation.class);

        Predicate combinedPredicates = criteriaBuilder.and(gpaPredicate, professorNamePredicate, courseTypePredicate);

        studentCriteriaQuery.select(studentRoot).where(combinedPredicates);

        TypedQuery<Student> studentTypedQuery = em.createQuery(studentCriteriaQuery);

        List<Student> resultList2 = studentTypedQuery.getResultList();

        System.out.println(resultList2);

        em.close();
        emf.close();
    }
}
