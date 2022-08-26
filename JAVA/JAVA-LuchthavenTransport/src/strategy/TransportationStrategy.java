package strategy;

import transportationBehaviour.CarBehaviour;
import transportationBehaviour.ITransportBehaviour;

/**
 * Author: Vervaeren Tom
 * Date: 07-11-2021
 */

public class TransportationStrategy {

    private ITransportBehaviour strategy;

    public TransportationStrategy() {
        this.strategy = new CarBehaviour();
    }

    public ITransportBehaviour getStrategy() {
        return strategy;
    }

    public void setStrategy(ITransportBehaviour strategy) {
        this.strategy = strategy;
    }

    @Override
    public String toString() {
        return strategy +
                "\n\t* Aangekomen in de luchthaven neem een trolly om je bagage te brengen tot aan de check in balie";
    }
}
