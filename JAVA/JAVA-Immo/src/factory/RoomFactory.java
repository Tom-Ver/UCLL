/**
 * @Author: Paulus Heleen, Vervaeren Tom
 * @Date: october 2021
 */
package factory;

import rooms.*;

public class RoomFactory {

    public static Room getRoomWithRandomOpp(int type){
        switch (type){
            case Room.SLAAPKAMER: return new Slaapkamer();
            case Room.BERGING: return new Berging();
            case Room.BUREAU: return new Bureau();
            case Room.GANG: return new Gang();
            case Room.KEUKEN: return new Keuken();
            case Room.SALON: return new Salon();
            case Room.BADKAMER: return new Badkamer();
            case Room.WC: return new Wc();
            case Room.WOONKAMER: return new Woonkamer();

            default: return null;
        }
    }

}
