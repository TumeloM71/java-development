package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDates {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("GMT"));
        LocalDateTime localNow = LocalDateTime.now();
        DateTimeFormatter df1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter df3 = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        DateTimeFormatter df4 = DateTimeFormatter.ofPattern("E, MMM dd, yyyy HH:mm");
        DateTimeFormatter df5 = DateTimeFormatter.ofPattern("HH:mm 'on' dd-MM-yyyy");
    //    System.out.println(now);
        System.out.println(date.format(df1));
        System.out.println(date.format(df2));
        System.out.println(date.format(df3));
        System.out.println(now.format(df4));
        System.out.println(localNow.format(df5));

    }
}
