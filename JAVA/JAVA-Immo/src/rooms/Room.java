/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package rooms;

import static test.TestImmo.random;

public abstract class Room {

    //Variabelen
    private double oppervlakte;
    public static final int SLAAPKAMER = 0;
    public static final int BERGING = 1;
    public static final int BUREAU = 2;
    public static final int GANG = 3;
    public static final int KEUKEN = 4;
    public static final int SALON = 5;
    public static final int BADKAMER = 6;
    public static final int WC = 7;
    public static final int WOONKAMER = 8;

    public Room(){
    }

    //Getters & Setters
    public double getOppervlakte() {
        return oppervlakte;
    }
    public double generateOpp(double maxOpp){
        return Math.round(random.nextDouble() * maxOpp);
    }

    public void setOppervlakte(double oppervlakte) {
        this.oppervlakte = oppervlakte;
    }

    //Methods
    @Override
    public String toString() {
        return "met als oppervlakte :" + oppervlakte + "\n";
    }
}

