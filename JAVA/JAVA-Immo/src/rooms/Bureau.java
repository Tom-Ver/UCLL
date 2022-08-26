/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package rooms;

public class Bureau extends Room{

    public static final double MAXOPP = 40;
    //Constructor
    public Bureau() {setOppervlakte(generateOpp(MAXOPP));}

    //Methods
    @Override
    public String toString() {
        return "\t- Bureau " + super.toString();
    }
}
