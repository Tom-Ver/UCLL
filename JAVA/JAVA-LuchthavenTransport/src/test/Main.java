/**
 * Author: Vervaeren Tom
 * Date: 07-11-2021
 */
package test;
import strategy.TransportationStrategy;
import transportationBehaviour.*;
import javax.swing.*;


public class Main {


    public static void main(String[] args) {

        //Variabel voor main functie
        int menuChoice = 1;
        int transportChoice;

        //Menu keuze transportmiddel
        do {
            try
            {
            transportChoice = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Welk transport wenst u te gebruiken? Kies een getal " +
                        "\n\t - 1. Auto " +
                        "\n\t - 2. Bus " +
                        "\n\t - 3. Taxi" +
                        "\n\t - 4. Trein "));

                //Als een verkeerde ingave (hoger of lager getal) ==> NumberFormatException.
                // Geen aparte exceptie aangemaakt vermits foutboodschap dezelfde blijft.
                if (transportChoice < 1 || transportChoice > 4){throw new NumberFormatException();}

                //Aanmaken van het transportmiddel + uitprint
                chooseTransport(transportChoice);

                //Nog eens??
                menuChoice = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Wenst u nog een keuze te maken?"+
                        "\n\t - 1. Ja " +
                        "\n\t - 2. Nee "));
            }
            catch (NumberFormatException  | NullPointerException e ){
                JOptionPane.showMessageDialog(null, "ONGELDIGE KEUZE");
            }
        }while(menuChoice == 1);
    }

    //Aanmaken van het transportmiddel + uitprint
    public static void chooseTransport(int chosen){
        //Auto is default behaviour voor TransportStrategy
        TransportationStrategy strategy = new TransportationStrategy();
        //strategy setStrategy naar gekozen transportmiddel.
        switch (chosen){
            case 1: strategy.setStrategy(new CarBehaviour());break;
            case 2: strategy.setStrategy(new BusBehaviour());break;
            case 3: strategy.setStrategy(new TaxiBehaviour());break;
            case 4: strategy.setStrategy(new TrainBehaviour());break;
        }
        //Uitprint van de te ondernemen stappen
        JOptionPane.showMessageDialog(null, strategy.toString());
    }
}

