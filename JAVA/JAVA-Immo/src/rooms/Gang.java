/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package rooms;

public class Gang extends Room{
    public static final double MAXOPP = 25;
    //Constructor
    public Gang() {
        setOppervlakte(generateOpp(MAXOPP));
    }

    //Methods

    @Override
    public String toString() {
        return "\t- Gang " + super.toString();
    }
}
