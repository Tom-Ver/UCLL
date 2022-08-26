/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package properties;


public class OpenBebouwing extends Huis {
    //VARIABELEN
    public static final double PRIJSPERUNIT = 85.00;
    public static final int MAXSLAAPKAMERS = 8;
    //Constructor
    public OpenBebouwing() {
        setPrijsPerUnit(PRIJSPERUNIT);
        roomsInHuis(MAXSLAAPKAMERS);
    }
    //--------------OVERRIDE TOSTRING()
    @Override
    public String toString() {
        return "\nOpen Bebouwing " + super.toString();
    }


}

