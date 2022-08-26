package transportationBehaviour;

public class TrainBehaviour implements ITransportBehaviour {
    @Override
    public String toString() {
        return  "\n\t* Boek een trein ticket naar de luchthaven" +
                "\n\t* Vraag aan buurman om je naar station te brengen" +
                "\n\t* Stap op de trein met je bagage";
    }
}
