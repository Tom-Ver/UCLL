/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package properties;


import interfaces.Balkon;
import interfaces.Garage;

import static test.TestImmo.random;

public class Loft extends Property implements Garage, Balkon {

    //Variabelen
    public static final double PRIJSPERUNIT = 45.00;
    public static final int MAXSLAAPKAMERS = 2;
    private boolean hasGarage;
    private boolean hasBalkon;

    //Constructor
    public Loft() {
        setPrijsPerUnit(PRIJSPERUNIT);
        roomsInLoft();
    }

    //METHODS
    public void roomsInLoft(){
        for (int i=0; i<=8;i++)
        {addRoomsWithRandomOpp(i);}
        for (int j=1; j<random.nextInt(MAXSLAAPKAMERS);j++)
        {addRoomsWithRandomOpp(0);}
        setHasGarage(random.nextBoolean());
        setHasBalkon(random.nextBoolean());
    }

    //--------------OVERRIDE INTERFACES
    @Override
    public void setHasBalkon(boolean hasBalkon) {this.hasBalkon = hasBalkon;
        if(hasBalkon){ setTotalePrijsInterfaces(balkonKost);}
    }
    @Override
    public boolean getHasBalkon(){
        return hasBalkon;
    }
    @Override
    public void setHasGarage(boolean hasGarage) {
        this.hasGarage = hasGarage;
        if(hasGarage){ setTotalePrijsInterfaces(garageKost);}

    }
    @Override
    public boolean getHasGarage() {
        return hasGarage;
    }

    // -------------- BEREKENING PRIJS
    public

    // --------------OVERRIDE TOSTRING()
    @Override
    String toString() {
        return "\nLoft " + super.toString() +
                "\n\t - Garage: " + getHasGarage() +
                "\n\t - Balkon: " + getHasBalkon() +
                "\n|--------------------------------------------------------------------------------------|";}
}
