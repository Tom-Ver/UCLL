/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package properties;

import interfaces.Garage;
import interfaces.Kelder;
import interfaces.Tuin;
import interfaces.Zolder;

import static test.TestImmo.random;

public abstract class Huis extends Property implements Garage, Zolder, Kelder, Tuin {
    boolean hasGarage;
    boolean hasKelder;
    boolean hasTuin;
    boolean hasZolder;

    //--------------OVERRIDE INTERFACE METHODS()
    @Override
    public void setHasGarage(boolean hasGarage) {this.hasGarage = hasGarage;
    if(hasGarage){ setTotalePrijsInterfaces(garageKost);}

    }
    @Override
    public boolean getHasGarage() {return hasGarage;}

    @Override
    public void setHasKelder(boolean hasKelder) {this.hasKelder = hasKelder;
        if(hasKelder){ setTotalePrijsInterfaces(kelderKost);}

    }

    @Override
    public boolean getHasKelder() {return hasKelder;}

    @Override
    public void setHasTuin(boolean hasTuin) {this.hasTuin = hasTuin;
        if(hasTuin){ setTotalePrijsInterfaces(tuinKost);}

    }

    @Override
    public boolean getHasTuin() {return hasTuin;}

    @Override
    public void setHasZolder(boolean hasZolder) {this.hasZolder = hasZolder;
        if(hasZolder){ setTotalePrijsInterfaces(zolderKost);}
    }

    @Override
    public boolean getHasZolder() {return hasZolder;}


    @Override
    public String toString() {
        return super.toString() +
                "\n\t - Garage: "   +getHasGarage() +
                "\n\t - Kelder: "   +getHasKelder() +
                "\n\t - Tuin: "     +getHasTuin() +
                "\n\t - Zolder: "   +getHasZolder() +
                "\n|--------------------------------------------------------------------------------------|";
    }
    //Methods
    public void roomsInHuis(int maxRooms){
        for (int i=0; i<=8;i++)
        {addRoomsWithRandomOpp(i);}
        for (int j=1; j<random.nextInt(maxRooms);j++)
        {addRoomsWithRandomOpp(0);}
        setHasGarage(random.nextBoolean());
        setHasTuin(random.nextBoolean());
        setHasKelder(random.nextBoolean());
        setHasZolder(random.nextBoolean());
    }




}


