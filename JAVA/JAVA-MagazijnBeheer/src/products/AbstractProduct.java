package products;

//import com.sun.org.apache.bcel.internal.classfile.Constant;
import exceptions.HighStockException;
import exceptions.LowStockException;
import states.State;
import stockmovements.StockMovement;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractProduct {

    protected List<StockMovement> stockMovementList = new LinkedList<StockMovement>();
    public static int MINSTOCK;
    public static int MAXSTOCK;
    public static int NORMALSTOCK;
    public static int CRITICAL;
    protected static int WEIGHT;
    protected State state;

    public AbstractProduct(int min, int max, int crit, int normal, int weight){
        this.CRITICAL=crit;
        this.MINSTOCK=min;
        this.MAXSTOCK = max;
        this.NORMALSTOCK = normal;
        this.WEIGHT = weight;
    }

    public abstract State getState();
    public abstract void addStockmovement(StockMovement stockMovement) throws HighStockException, LowStockException;




}
