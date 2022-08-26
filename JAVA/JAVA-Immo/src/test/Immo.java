/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package test;

import properties.Property;
import factory.PropertyFactory;

import java.util.ArrayList;

import static test.TestImmo.random;

public class Immo {
    public static ArrayList<Property> properties = new ArrayList<>();

    public void generateHouses(int aantal){
        for (int i=0; i<aantal;i++) {
            Property propToAdd = PropertyFactory.getProperty(random.nextInt(6));
            properties.add(propToAdd);
        }
    }
}
