package org.progmatic.nov25;

import java.time.LocalDate;

public class DateConverter {

    public static void main(String[] args) {
        DateConverter date = new DateConverter();
        System.out.println(date.string2Date("1996-10-14"));
    }

    public LocalDate string2Date(String s) {
        LocalDate date = null;
        try {
            date = LocalDate.parse(s);
        }
        catch (Exception e) {
            System.out.println("Helyes formátum: ÉÉÉÉ-HH-NN");
        }
        return date;
    }
}
