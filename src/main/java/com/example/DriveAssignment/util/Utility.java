package com.example.DriveAssignment.util;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utility {
    public static LocalDate formatStringToDate(String date) throws ParseException {
        if(date.matches("\\d{2}/\\d{2}/\\d{4}")){
            return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
            return null;
    }
}
