package stockmovements;

public abstract class StockMovement {
    private int quantity;

    public StockMovement(int quantity){
        this.quantity=quantity;

    }

    public int getQuantity() {
        return quantity;
    }

    public abstract String toString();

}
