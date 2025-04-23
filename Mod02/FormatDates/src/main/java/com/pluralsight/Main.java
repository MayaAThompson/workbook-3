package com.pluralsight;

import java.time.LocalDate;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println(DateFormats.monthDayYear());
        System.out.println(DateFormats.yearMonthDay());
        System.out.println(DateFormats.longMonthDayYear());
        System.out.println(DateFormats.dateAndTime());
    }
}
