package date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateCalculator {

    //Variabelen
    private static final LocalDate RANDOMSUNDAY = LocalDate.of(2021,10,24);

    //Constructor
    public DateCalculator() {
    }

    //Getters & Setters
    public LocalDate getRandomSunday() {
        return RANDOMSUNDAY;
    }

    //Methods

    public int compareDate(LocalDate dateToCompare){
        long diff = ChronoUnit.DAYS.between(getRandomSunday(), dateToCompare);
        int dayOfWeek = (int)diff%7;
        if (dayOfWeek < 0){dayOfWeek += 7;}
        return dayOfWeek;
    }

    public String getDayOfWeekString(String dateToCompareString){
        LocalDate dateToCompare = LocalDate.parse(dateToCompareString);
        int dayOfWeek = compareDate(dateToCompare);
        switch (dayOfWeek){
            case 0 : return "SUNDAY";
            case 1 : return "MONDAY";
            case 2 : return "TUESDAY";
            case 3 : return "WEDNESDAY";
            case 4 : return "THURSDAY";
            case 5 : return "FRIDAY";
            case 6 : return "SATURDAY";
            default: return "Er is een fout opgetreden.";
         }
    }
}
