/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package properties;


public class HalfOpenBebouwing extends Huis  {

    //VARIABELEN
    public static final double PRIJSPERUNIT = 65.00;
    public static final int MAXSLAAPKAMERS = 5;

    //Constructor
    public HalfOpenBebouwing() {
        setPrijsPerUnit(PRIJSPERUNIT);
        roomsInHuis(MAXSLAAPKAMERS);
    }

    //--------------OVERRIDE TOSTRING()
    @Override
    public String toString() {
        return "\nHalf-Open Bebouwing " + super.toString();
    }

}
