/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package test;

import javax.swing.*;

import java.util.Random;



public class TestImmo {

    public static Random random = new Random();

    public static void main(String[] args){
        Immo immo = new Immo();
        char menuKeuze;
        do {
            String answer = JOptionPane.showInputDialog(null,
                    "Kan u het aantal gewenste woningen in uw portfolio ingeven?\n" +
                            "Het portfolio wordt dan automatisch en willekeurig gegenereerd.");
            try{
                int numberOfProperties = Integer.parseInt(answer);
                immo.generateHouses(numberOfProperties);
                String toShow = immo.properties.toString();
                System.out.println(toShow);
                menuKeuze = (JOptionPane.showInputDialog(null, "Wenst u nog huizen toe te voegen? (j/n)")).charAt(0);

            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Er is geen nummer ingegeven!");
                menuKeuze = (JOptionPane.showInputDialog(null, "Wenst u nog huizen toe te voegen? (j/n)")).charAt(0);
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "Er werd een fout gevonden!");
                menuKeuze = (JOptionPane.showInputDialog(null, "Wenst u nog huizen toe te voegen? (j/n)")).charAt(0);
            }

        } while (menuKeuze == 'j' ||menuKeuze == 'J');

    }
}
