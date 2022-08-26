package transportationBehaviour;

public class TaxiBehaviour implements ITransportBehaviour{
    @Override
    public String toString() {
        return  "\n\t* Bel de taxi maatschappij" +
                "\n\t* Laad je bagage door de taxi chauffeur in laden" +
                "\n\t* Je wordt naar de luchthaven gebracht";
    }
}
