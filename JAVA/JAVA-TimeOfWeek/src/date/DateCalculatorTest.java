package date;


import org.junit.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class DateCalculatorTest {


    private DateCalculator dateCalculator;

    @Before
    public void setUp(){
        dateCalculator = new DateCalculator();
    }
    //TEST RETURN VALUE TRUE FOR MULTIPLE DAYS
    @Test
    public void test_getDayOfWeekString_ReturnValue_Klopt(){
        for (int i = 10; i < 20 ; i++) {
            String dayOfWeek=dateCalculator.getDayOfWeekString("2021-03-" + i);
            assertEquals(dayOfWeek, LocalDate.of(2021,03,i).getDayOfWeek().toString());
        }
    }
    //TEST EXCEPTION IF INPUT != DATE || WRONG NOTATION
    @Test (expected = DateTimeParseException.class)
    public void test_getDayOfWeekString_FalseInput(){
        dateCalculator.getDayOfWeekString("Dit is een test");
    }

    @After
    public void tearDown(){}
}

