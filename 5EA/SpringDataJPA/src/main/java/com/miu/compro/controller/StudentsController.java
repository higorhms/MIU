package com.miu.compro.controller;

import com.miu.compro.entities.Student;
import com.miu.compro.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public List<Student> getByGpaAndHaveABookWithMoreThanPages(@RequestParam("gpa") int gpa, @RequestParam("numberOfPages") int numberOfPages) {
        return studentsService.findAllStudentsWithGpaLessThanAndHaveABookWithMoreThanPages(gpa, numberOfPages);
    }

    @DeleteMapping("/{student_id}")
    public void deleteOne(@PathVariable int student_id){
        studentsService.deleteById(student_id);
    }

    @GetMapping("/{student_id}")
    public Student findOne(@PathVariable int student_id){
        return studentsService.findOne(student_id);
    }

    @PostMapping("")
    public Student createOne(@RequestBody Student student){
        return this.studentsService.createOne(student);
    }

    @PutMapping("/{id}")
    public Student updateUser(@PathVariable int id, @RequestBody Student partialStudent) {
        partialStudent.setId(id);
        return this.studentsService.createOne(partialStudent);
    }

    @PatchMapping("/{id}")
    public Student patchUser(@PathVariable int id, @RequestBody Map<String, Object> fieldsToUpdate) {
        return this.studentsService.updateOne(id, fieldsToUpdate);
    }
}
