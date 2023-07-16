package com.miu.compro.listeners;

import com.miu.compro.entities.Student;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StudentEventListener {
    Logger log = LoggerFactory.getLogger(StudentEventListener.class);

    @PrePersist
    public void userPrePersist(Student student) {
        log.info("Pre Persist: " + student.toString());
    }

    @PostPersist
    public void userPostPersist(Student student) {
        log.info("Post Persist: " + student.toString());
    }
}