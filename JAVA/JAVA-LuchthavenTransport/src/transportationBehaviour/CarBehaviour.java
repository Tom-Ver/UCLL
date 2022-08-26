package transportationBehaviour;

public class CarBehaviour implements ITransportBehaviour {

    @Override
    public String toString() {
        return  "\n\t* Laad bagage in de auto" +
                "\n\t* Rijdt naar het tankstation en tank je tank vol" +
                "\n\t* Stel waze in naar de luchthaven" +
                "\n\t* Parkeer je wagen in de publieke parking";
    }
}
