/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package rooms;

public class Woonkamer extends Room{
    public static final double MAXOPP = 60;
    //Constructor
    public Woonkamer(){
        setOppervlakte(generateOpp(MAXOPP));
    }

    //Methods
    @Override
    public String toString() {
        return "\t- Woonkamer " + super.toString();
    }
}

