/**
 * Author: Vervaeren Tom
 * Date: 07-11-2021
 */
package test;
import org.junit.*;
import strategy.TransportationStrategy;
import transportationBehaviour.BusBehaviour;
import transportationBehaviour.CarBehaviour;
import transportationBehaviour.TaxiBehaviour;
import transportationBehaviour.TrainBehaviour;

import static org.junit.Assert.*;

public class TransportationStrategyTest {

    //Variabelen
    private TransportationStrategy strategy;
    //Extra variabelen voor test_Strategy_ToStringMethod_Different
    private CarBehaviour carBehaviour = new CarBehaviour();
    private BusBehaviour busBehaviour = new BusBehaviour();
    private TaxiBehaviour taxiBehaviour = new TaxiBehaviour();
    private TrainBehaviour trainBehaviour = new TrainBehaviour();

    @Before
    public void setUp() {strategy = new TransportationStrategy();};

    //Test verander telkens de behaviour van strategy en test op de uitkomst
    //Alle tests in 1 method. Voor iedere Behaviour een andere test is in mijn opzicht in deze context een beetje overdreven
    @Test
    public void test_Set_Strategy_True(){
        strategy.setStrategy(new CarBehaviour());
        assertEquals(strategy.getStrategy().toString(),carBehaviour.toString());
        strategy.setStrategy(new TaxiBehaviour());
        assertEquals(strategy.getStrategy().toString(),taxiBehaviour.toString());
        strategy.setStrategy(new BusBehaviour());
        assertEquals(strategy.getStrategy().toString(),busBehaviour.toString());
        strategy.setStrategy(new TrainBehaviour());
        assertEquals(strategy.getStrategy().toString(),trainBehaviour.toString());
    }

    //Test behaviour ToString() verschillend van de ToString van strategy. || EXTRA LIJN IN DE TOSTRING(), "Aangekomen in de ..." ||
    @Test
    public void test_Strategy_ToStringMethod_Different(){
        strategy.setStrategy(new CarBehaviour());
        assertNotEquals(strategy.toString(),carBehaviour.toString());
        strategy.setStrategy(new TaxiBehaviour());
        assertNotEquals(strategy.toString(),taxiBehaviour.toString());
        strategy.setStrategy(new BusBehaviour());
        assertNotEquals(strategy.toString(),busBehaviour.toString());
        strategy.setStrategy(new TrainBehaviour());
        assertNotEquals(strategy.toString(),trainBehaviour.toString());
    }


    @After
    public void tearDown(){};
}
