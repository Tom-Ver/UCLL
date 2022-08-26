package stockmovements;

public class StockOut extends StockMovement{
    private DescriptionOut description;

    public StockOut(int quantity, DescriptionOut description){
        super(quantity);
        this.description = description;
    }

    public DescriptionOut getDescription() {
        return description;
    }
    public String toString() {
        return "+" + super.getQuantity() +"," + getDescription();
    }
}
