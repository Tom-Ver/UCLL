/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package rooms;

public class Wc extends Room{
    public static final double MAXOPP = 15;
    //Constructor
    public Wc()    {setOppervlakte(generateOpp(MAXOPP));}


    //Methods
    @Override
    public String toString() {
        return "\t- Wc " + super.toString();
    }
}
