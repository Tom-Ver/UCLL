package stockmovements;

import java.util.Random;

public enum DescriptionOut implements Description{ VERKOOP,QUARANTAINE,VERNIETIGING,KWALITEITSPROBLEEM;

    public static DescriptionOut getRandomDescriptionOut() {
        Random random = new Random();

        DescriptionOut desc  = values()[random.nextInt(values().length)];
        return desc;
    }
}
