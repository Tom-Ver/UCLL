/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package rooms;

public class Keuken extends Room{
    public static final double MAXOPP = 50;
    //Constructor
    public Keuken() {
        setOppervlakte(generateOpp(MAXOPP));
    }

    //Methods
    @Override
    public String toString() {
        return "\t- Keuken " + super.toString();
    }
}
