/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package rooms;

public class Berging extends Room{

    public static final double MAXOPP = 20;
    //Constructor
    public Berging() {
        setOppervlakte(generateOpp(MAXOPP));
    }

    //Methods

    @Override
    public String toString() {
        return "\t- Berging " + super.toString();
    }
}
