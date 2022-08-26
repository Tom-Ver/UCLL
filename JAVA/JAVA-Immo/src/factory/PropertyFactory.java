/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package factory;

import properties.*;


public class PropertyFactory {

    public static Property getProperty(int type){
        switch (type){
            case Property.STUDENTENKOT : return new Studentenkot();
            case Property.LOFT: return new Loft();
            case Property.APPARTEMENT: return new Appartement();
            case Property.GESLOTENBEBOUWING: return new GeslotenBebouwing();
            case Property.HALFOPENBEBOUWING: return new HalfOpenBebouwing();
            case Property.OPENBEBOUWING: return new OpenBebouwing();

            default: return null;
        }
}
}
