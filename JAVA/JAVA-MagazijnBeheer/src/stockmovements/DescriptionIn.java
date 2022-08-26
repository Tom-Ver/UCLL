package stockmovements;

import java.util.Random;

public enum DescriptionIn implements Description{
    LEVERING, PRODUCTIE,INIT;

    public static DescriptionIn getRandomDescriptionIn() {
        Random random = new Random();

        DescriptionIn desc  = values()[random.nextInt(values().length)];
        while (desc == INIT){
            desc = values()[random.nextInt(values().length)];
        }
        return desc;
    }
}
