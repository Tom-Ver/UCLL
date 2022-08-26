/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package properties;


public class GeslotenBebouwing extends Huis {

    //Variabelen
    public static final double PRIJSPERUNIT = 45.00;
    public static final int MAXSLAAPKAMERS = 3;

    //Constructor
    public GeslotenBebouwing() {
        setPrijsPerUnit(PRIJSPERUNIT);
        roomsInHuis(MAXSLAAPKAMERS);

    }

    //--------------OVERRIDE TOSTRING()
    @Override
    public String toString() {
        return "\nGeslotenBebouwing " + super.toString();
    }





}
