package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
/*
Create a Java application named FormatDates. The application will get the
current date and time and display that information in the following formats
09/05/2021
2021-09-05
September 5, 2021
Sunday, Sep 5, 2021 10:02 ß display in GMT time
CHALLENGE
5:02 on 05-Sep-2021 ß display in your local time zone
 */

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
