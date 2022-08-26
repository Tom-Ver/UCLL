package stockmovements;

public class StockIn extends StockMovement{

    private DescriptionIn description;
    public StockIn(int quantity, DescriptionIn description){
        super(quantity);
        this.description = description;
    }

    public String toString() {
        return "+" + super.getQuantity() +"," + description;
    }


}
