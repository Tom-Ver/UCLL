/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package properties;

import rooms.Room;
import factory.RoomFactory;

import java.util.ArrayList;

public abstract class Property {

    //Variabelen
    private double totaleOppervlakte;
    private double prijsPerUnit;
    private double totalePrijs;



        //--------------Mogelijke properties
    public static final int STUDENTENKOT = 0;
    public static final int LOFT = 1;
    public static final int APPARTEMENT = 2;
    public static final int GESLOTENBEBOUWING = 3;
    public static final int HALFOPENBEBOUWING = 4;
    public static final int OPENBEBOUWING = 5;

        //--------------Lijst waarin de kamers van een welbepaalde property worden opgeslagen
    private ArrayList<Room> rooms;

    //CONSTRUCTOR
    public Property() {
        rooms = new ArrayList<Room>();
    }

    //METHODS

    public void addRoomsWithRandomOpp(int kamer){
        Room roomToAdd = RoomFactory.getRoomWithRandomOpp(kamer);
        try{
            this.rooms.add(roomToAdd);
            setPrijsPerUnit(prijsPerUnit);
            setTotaleOppervlakte(roomToAdd.getOppervlakte());
            setTotalePrijs();}
        catch (Exception e){
            System.out.println(roomToAdd + e.toString());
        }
    }

        //--------------OVERRIDE TOSTRING()
    @Override
    public String toString() {
        return  "\n-------------------"+
                "\nEigenschappen: " +
                " \n\t" + " - totaleOppervlakte=" + totaleOppervlakte +
                ", \n\t" +" - prijsPerUnit=" + prijsPerUnit +
                ", \n\t" +" - totalePrijs=" + totalePrijs +
                ", \n"+ "- Kamers:" + "\n" + rooms +
                "\n Extra's: ";
    }

        //--------------GETTERS & SETTERS
    public double getTotaleOppervlakte() {return totaleOppervlakte;}
    public void setTotaleOppervlakte(double oppervlakte) {
        this.totaleOppervlakte += oppervlakte;
    }
    public double getTotalePrijs() {return totalePrijs;}
    public void setTotalePrijs() {this.totalePrijs = totaleOppervlakte*getPrijsPerUnit();}
    public void setTotalePrijsInterfaces(double multiplier){ this.totalePrijs *= multiplier;}
    public double getPrijsPerUnit() {return prijsPerUnit;}
    public void setPrijsPerUnit(double prijsPerUnit) {this.prijsPerUnit = prijsPerUnit;}
}

