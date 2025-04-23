package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormats {

    public static String monthDayYear() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.now();
        return date.format(formatter);
    }

    public static LocalDate yearMonthDay() {
        return LocalDate.now();
    }

    public static String longMonthDayYear() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        LocalDate date = LocalDate.now();
        return date.format(formatter);
    }

    public static String dateAndTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.format(formatter);
    }


}
