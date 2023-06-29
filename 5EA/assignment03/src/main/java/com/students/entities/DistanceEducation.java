package com.students.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class DistanceEducation extends Course {
    private String examProfessor;

    @ElementCollection
    @Temporal(TemporalType.DATE)
    private List<Date> webinarSessions = new ArrayList<>();

    public DistanceEducation(String examProfessor, List<Date> webinarSessions) {
        this.examProfessor = examProfessor;
        this.webinarSessions = webinarSessions;
    }

    public DistanceEducation(String title, Date startDate, String professorName, String examProfessor) {
        super(title, startDate, professorName);
        this.examProfessor = examProfessor;
    }

    public DistanceEducation() {
    }

    public String getExamProfessor() {
        return examProfessor;
    }

    public void setExamProfessor(String examProfessor) {
        this.examProfessor = examProfessor;
    }

    public void setWebinarSessions(List<Date> webinarSessions) {
        this.webinarSessions = webinarSessions;
    }

}
