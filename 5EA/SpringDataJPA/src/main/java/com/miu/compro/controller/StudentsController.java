package com.miu.compro.controller;

import com.miu.compro.entities.Student;
import com.miu.compro.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {
    private StudentsService studentsService;

    @Autowired
    public StudentsController(StudentsService studentsService){
        this.studentsService = studentsService;
    }

    @GetMapping("")
    public List<Student> getAll(){
        return this.studentsService.getAll();
    }

    @GetMapping("/gpa")
    public List<Student> getByGPA(@RequestParam("gpa") int gpa) {
        return studentsService.getByGPA(gpa);
    }

    @GetMapping("/qualified")
    public List<Student> getQualifiedForGraduation() {
        return studentsService.getQualifiedForGraduation();
    }

    @GetMapping("/criteria")
    public List<Student> getByGpaAndHaveABookWithMoreThanPages(
            @RequestParam("gpa") int gpa,
            @RequestParam("numberOfPages") int numberOfPages) {
        return studentsService.findAllStudentsWithGpaLessThanAndHaveABookWithMoreThanPages(gpa, numberOfPages);
    }
}
