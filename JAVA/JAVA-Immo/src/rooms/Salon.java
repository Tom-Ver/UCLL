/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package rooms;

public class Salon extends Room{
    public static final double MAXOPP = 60;
    //Constructor
    public Salon() {
        setOppervlakte(generateOpp(MAXOPP));
    }

    //Methods

    @Override
    public String toString() {
        return "\t- Salon " + super.toString();
    }
}
