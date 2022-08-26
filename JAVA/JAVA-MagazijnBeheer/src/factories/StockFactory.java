package factories;

import exceptions.InitialStockException;
import stockmovements.*;

public class StockFactory {

    //Initial stock needed for product creation
    public StockMovement addInitStock(int quantity){
        StockMovement stockInit = new StockIn(quantity, DescriptionIn.INIT);
        return stockInit;
    }

    //Stockmovements after initial stock
    public StockMovement getStockmovement(Boolean InOut, int quantity, Description description) throws InitialStockException {
        StockMovement stock;
        if(description == DescriptionIn.INIT){throw new InitialStockException();}
        else{
            if (InOut) {
                stock = new StockIn(quantity, (DescriptionIn) description);
            } else if (!(InOut)) {
                stock = new StockOut(quantity, (DescriptionOut) description);
            } else {
                stock = null;
            }
        }
        return stock;

    }


}
