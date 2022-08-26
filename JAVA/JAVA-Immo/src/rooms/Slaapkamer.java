/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package rooms;

public class Slaapkamer extends Room{
    public static final double MAXOPP = 50;
    //Constructor
    public Slaapkamer() {
        setOppervlakte(generateOpp(MAXOPP));
    }

    //Methods
    @Override
    public String toString() {
        return "\t- Slaapkamer " + super.toString();
    }
}
