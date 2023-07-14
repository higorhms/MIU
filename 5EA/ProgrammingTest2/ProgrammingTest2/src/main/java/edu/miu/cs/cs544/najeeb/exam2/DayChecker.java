package edu.miu.cs.cs544.najeeb.exam2;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayChecker {

    private DayOfWeek unAuthorizedDay= DayOfWeek.SUNDAY;

    public DayChecker(DayOfWeek unAuthorizedDay) {
        this.unAuthorizedDay = unAuthorizedDay;
    }

    public boolean isTodayAuthorized() {
        return LocalDate.now().getDayOfWeek() != unAuthorizedDay;
    }
}
