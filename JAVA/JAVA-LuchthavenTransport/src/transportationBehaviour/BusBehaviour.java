package transportationBehaviour;

public class BusBehaviour implements ITransportBehaviour{
    @Override
    public String toString() {
        return  "\n\t* Koop on-line een busticket" +
                "\n\t* Ga naar de dichtbijzijnde bushalte" +
                "\n\t* Neem de 1ste bus" +
                "\n\t* Je wordt tot aan de dichtsbijzijnde grote stad gebracht" +
                "\n\t* Ga naar je overstap halte" +
                "\n\t* Neem de 2de bus" +
                "\n\t* Je wordt naar de luchthaven gebracht";
    }
}
