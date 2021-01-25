package com.example.date.to.words;

import lombok.AllArgsConstructor;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class DateToWords {


    private final static Map<Integer, String> DIGITS_TO_WORDS;
    static {
        DIGITS_TO_WORDS = new HashMap<>();
        DIGITS_TO_WORDS.put(0, "twelve");
        DIGITS_TO_WORDS.put(1, "one");
        DIGITS_TO_WORDS.put(2, "two");
        DIGITS_TO_WORDS.put(3, "three");
        DIGITS_TO_WORDS.put(4, "four");
        DIGITS_TO_WORDS.put(5, "five");
        DIGITS_TO_WORDS.put(6, "six");
        DIGITS_TO_WORDS.put(7, "seven");
        DIGITS_TO_WORDS.put(8, "eight");
        DIGITS_TO_WORDS.put(9, "nine");
        DIGITS_TO_WORDS.put(10, "ten");
        DIGITS_TO_WORDS.put(11, "eleven");
        DIGITS_TO_WORDS.put(12, "twelve");
        DIGITS_TO_WORDS.put(13, "thirteen");
        DIGITS_TO_WORDS.put(14, "fourteen");
        DIGITS_TO_WORDS.put(15, "fifteen");
        DIGITS_TO_WORDS.put(16, "sixteen");
        DIGITS_TO_WORDS.put(17, "seventeen");
        DIGITS_TO_WORDS.put(18, "eighteen");
        DIGITS_TO_WORDS.put(19, "nineteen");
        DIGITS_TO_WORDS.put(20, "twenty");
        DIGITS_TO_WORDS.put(21, "twenty one");
        DIGITS_TO_WORDS.put(22, "twenty two");
        DIGITS_TO_WORDS.put(23, "twenty three");
        DIGITS_TO_WORDS.put(24, "twenty four");
        DIGITS_TO_WORDS.put(25, "twenty five");
        DIGITS_TO_WORDS.put(26, "twenty six");
        DIGITS_TO_WORDS.put(27, "twenty seven");
        DIGITS_TO_WORDS.put(28, "twenty eight");
        DIGITS_TO_WORDS.put(29, "twenty nine");
    }


    public String convert(String time) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        LocalTime localTime = null;

        try {
            localTime = LocalTime.parse(time + " PM", dateTimeFormatter);
        }catch (DateTimeException e){
        }
        if (localTime != null) {
            if (localTime.getMinute() == 0) {
                return DIGITS_TO_WORDS.get(localTime.get(ChronoField.HOUR_OF_AMPM)) + " o clock";
            } else if (localTime.getMinute() < 30) {
                if (localTime.getMinute() == 15)
                    return "quoter past " + DIGITS_TO_WORDS.get(localTime.get(ChronoField.HOUR_OF_AMPM));
                return DIGITS_TO_WORDS.get(localTime.getMinute()) +
                        " past " + DIGITS_TO_WORDS.get(localTime.get(ChronoField.HOUR_OF_AMPM));
            } else if (localTime.getMinute() > 30) {
                if (localTime.getMinute() == 45)
                    return "quoter to " + DIGITS_TO_WORDS.get(localTime.get(ChronoField.HOUR_OF_AMPM));
                return DIGITS_TO_WORDS.get(60 - localTime.getMinute()) +
                        " to " + DIGITS_TO_WORDS.get(localTime.get(ChronoField.HOUR_OF_AMPM));
            }

            return "half past " + DIGITS_TO_WORDS.get(localTime.get(ChronoField.HOUR_OF_AMPM));
        }
        return "wrong time format provided";
    }
}
