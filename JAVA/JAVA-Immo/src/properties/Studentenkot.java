/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package properties;

public class Studentenkot extends Property {

    public static final double PRIJSPERUNIT = 15.00;

    //studentenkamer heeft enkel een slaapkamer
    //CONSTRUCTOR
    public Studentenkot() {
        setPrijsPerUnit(PRIJSPERUNIT);
        addRoomsWithRandomOpp(0);
    }

    //METHOD
    @Override
    public String toString() {
        return "\nStudentenkot " + super.toString() +
                "\n|--------------------------------------------------------------------------------------|";
    }
}

