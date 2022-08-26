package products;
import exceptions.HighStockException;
import exceptions.LowStockException;
import states.*;
import stockmovements.StockMovement;

import java.util.Iterator;

public class Product extends AbstractProduct implements Comparable<Product> {

    //CONSTRUCTOR
    public Product(int max, int min, int crit, int normal, int weight){
        super(min,max,crit,normal,weight);
    }


    //Geeft de status weer waarin het product zich bevind. Zie ParentClass ==> AbstractProduct
    public State getState(){
        return this.state;
    }

    //Toevoegen van stockbewegingen aan de lijst in Product. Zie ParentClass ==> AbstractProduct
    public void addStockmovement(StockMovement stockMovement) throws HighStockException, LowStockException {
        int quantity = actualStock();
        int goalQuantity = quantity + stockMovement.getQuantity();
        if(goalQuantity > NORMALSTOCK && goalQuantity <= MAXSTOCK){state = new StateHigh(); stockMovementList.add(stockMovement);}
        else if(goalQuantity > MINSTOCK && goalQuantity <= NORMALSTOCK){state = new StateNormal(); stockMovementList.add(stockMovement);}
        else if(goalQuantity > CRITICAL && goalQuantity <= MINSTOCK){state = new StateLow(); stockMovementList.add(stockMovement);}
        else if(goalQuantity > 0 && goalQuantity <= CRITICAL){state = new StateCritical(); stockMovementList.add(stockMovement);}
        else if(goalQuantity > MAXSTOCK){throw new HighStockException();}
        else{throw new LowStockException();}
    }

    //Weergeven van actuele stock
    public int actualStock(){
        int quantity = 0;
        Iterator it = stockMovementList.listIterator();
        while (it.hasNext())
        {
            StockMovement s= (StockMovement) it.next();
            int q = s.getQuantity();
            quantity += q;
        }
        return quantity;
    }

    @Override
    public String toString() {
        return "Product: " +"\n\t" +
                "- Max stock: " + this.MAXSTOCK + "\n\t" +
                "- Normal stock: " + this.NORMALSTOCK + "\n\t" +
                "- Low stock: " + this.MINSTOCK + "\n\t" +
                "- Critical stock: " + this.CRITICAL + "\n\t" + actualStock() +
                "- State: " + getState();
    }
    public void printStockmovements(){
        for (StockMovement s: stockMovementList) {

        }
    }

    @Override
    public int compareTo(Product o) {
        if(WEIGHT == o.WEIGHT)
            return 0;
        else if(WEIGHT>o.WEIGHT)
            return 1;
        else
            return -1;
    }
}

