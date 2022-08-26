package main;

import date.DateCalculator;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Test {

    public static void main(String[] args){

        DateCalculator dateCalculator = new DateCalculator();
        char menu;


        do {
            String dateToCompareString = JOptionPane.showInputDialog(null, "Geef een datum in waarvan je de dag wil kennen (yyyy-mm-dd)");
            try{
                String day = dateCalculator.getDayOfWeekString(dateToCompareString);
                JOptionPane.showMessageDialog(null, "Datum " + dateToCompareString + " is een " + day );}
            catch (DateTimeParseException e){
                JOptionPane.showMessageDialog(null, "Geen geldige datum invoer!");
            }
            finally {
                menu = JOptionPane.showInputDialog(null, "Wenst u nog een datum in te geven?").toUpperCase().charAt(0);
            }
        } while (menu == 'J');

    }


}
