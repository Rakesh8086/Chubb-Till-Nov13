package com.app.work;

import java.time.*;
import java.util.*;
import java.util.stream.*;

public class WeekendFinder {
    public static void main(String[] args) {
        int year = 2025;
        Month month = Month.NOVEMBER;

        List<LocalDate> weekends = IntStream.rangeClosed(1, month.length(Year.isLeap(year)))
                .mapToObj(day -> LocalDate.of(year, month, day))
                .filter(date -> {
                    DayOfWeek dow = date.getDayOfWeek();
                    return dow == DayOfWeek.SATURDAY || dow == DayOfWeek.SUNDAY;
                })
                .collect(Collectors.toList());

        System.out.println("Saturdays and Sundays in " + month + " " + year + ":");
        weekends.forEach(System.out::println);
    }
}
