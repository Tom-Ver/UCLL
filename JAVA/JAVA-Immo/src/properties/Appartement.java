/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package properties;

import interfaces.Balkon;
import interfaces.Garage;

import static test.TestImmo.random;

public class Appartement extends Property implements Garage, Balkon {

    //Variabelen
    public static final double PRIJSPERUNIT = 35.00;
    public static final int MAXSLAAPKAMERS = 3;
    private boolean hasGarage;
    private boolean hasBalkon;

    //Een appartement heeft een keuken, 1 of 2 slaapkamers, gang, woonkamer, berging, badkamer, wc en salon, deze kan een garage en een balkon hebben
    //Constructor
    public Appartement() {
        setPrijsPerUnit(PRIJSPERUNIT);
        roomsInAppartement();

    }

    //METHODS
    public void roomsInAppartement(){
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


    //--------------OVERRIDE setUnitPrice() When an extra is added
    @Override
    public void setPrijsPerUnit(double prijsPerUnit) {

            super.setPrijsPerUnit(prijsPerUnit);

    }

    //--------------OVERRIDE TOSTRING()
    @Override
    public String toString() {
        return "\nAppartement " + super.toString() +
                "\n\t - Garage: " + getHasGarage() +
                "\n\t - Balkon: " + getHasBalkon() +
                "\n|--------------------------------------------------------------------------------------|";
    }
}
