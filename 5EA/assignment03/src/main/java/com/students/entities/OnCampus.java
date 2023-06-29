package com.students.entities;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class OnCampus extends Course{
    private String room;

    private int capacity;

    public OnCampus(String title, Date startDate, String professorName, String room, int capacity) {
        super(title, startDate, professorName);
        this.room = room;
        this.capacity = capacity;
    }

    public OnCampus() {
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
