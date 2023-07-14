package com.example.repository;

import com.example.entities.Book;
import com.example.entities.Student;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class StudentSpecification {

    public static Specification<Student> hasGpaGreaterThan(int gpa){
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("gpa"), gpa);
    }

    public static Specification<Student> findAllStudentsWithGpaLessThanAndHaveABookWithMoreThanPages(int gpa, int pages){
        return new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate gpaPredicate = criteriaBuilder.lessThanOrEqualTo(root.get("gpa"), gpa);
                Join<Student, Book> booksJoin = root.join("books");
                Predicate bookPagesPredicate = criteriaBuilder.greaterThanOrEqualTo(booksJoin.get("numberOfPages"), pages);
                return criteriaBuilder.and(gpaPredicate, bookPagesPredicate);
            }
        };
    }
}
