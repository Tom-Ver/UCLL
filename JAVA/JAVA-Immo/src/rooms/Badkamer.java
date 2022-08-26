/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package rooms;

import java.util.Random;

public class Badkamer extends Room{

    public static final double MAXOPP = 40;
    Random random = new Random();
    //Constructor
    public Badkamer(){setOppervlakte(generateOpp(MAXOPP));}

    //Methods
    @Override
    public String toString() {
        return "\t- Badkamer " + super.toString();
    }



}