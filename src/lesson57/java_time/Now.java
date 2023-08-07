package lesson57.java_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Now {

    public static void main(String[] args) {
        LocalTime currentTime = LocalTime.now();
        System.out.println("Сейчас: " + currentTime);

        LocalDate currentDate = LocalDate.now();
        System.out.println("Сегодня: " + currentDate);

        ZonedDateTime current = LocalDateTime.of(currentDate, currentTime)
            .atZone(ZoneId.systemDefault());

        System.out.println("Сегодня и сейчас: " + current.format(DateTimeFormatter.ofLocalizedDate(
            FormatStyle.LONG)));
    }
}

