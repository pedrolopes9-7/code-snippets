package com.linkedin.codesnippets.datetime;

import java.time.*;
import java.util.Date;

// In Los Angeles Time Zone, Daylight Saving Time began at: March 12, 2023 02:00.
// Considering that, what's the output for the code below?
// a - 2023-03-12T03:00
// b - 2023-03-12T02:00
// c - Runtime Exception at //1
// d - Compilation Error

public class DatesExample {
    public static void main(String[] args) {
        Date date = new Date(2023, 3, 12); // creates the date March 12, 2023
        LocalTime localTime = LocalTime.of(0001, 59, 59); //1 -> creates the time 01:59:59
        LocalDateTime localDateTime = LocalDateTime.of(date, localTime);
        ZonedDateTime dateBeforeDST = ZonedDateTime.of(localDateTime, ZoneId.of("America/Los_Angeles"));

        LocalDateTime dateAfterDST = dateBeforeDST.plusSeconds(1).toLocalDateTime();
        System.out.println(dateAfterDST);
    }
}

//The code doesn't compile since LocalDateTime.of doesn't accept a Date object as argument.
//However, if we've passed a LocalDate to it, using the same year, month, and day, the code would output 2023-03-12T03:00.
//That's because the ZonedDateTime class handles Daylight Saving time automatically. So, it increments one hour to the
//current time after reaching 02:00 AM, the time that DST starts in Los Angeles.
