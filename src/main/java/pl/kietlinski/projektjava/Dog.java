package pl.kietlinski.projektjava;

import lombok.Data;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Data
@Component
public class Dog {
    private int lvlValue;
    private int expValue;
    private boolean cleanUp;
    private boolean washDog;
    private long time;

    public Dog() {
        this.lvlValue = 1;
        this.expValue = 0;
        this.cleanUp = false;
        this.washDog = false;
    }

    public void upExpValue() {
        expValue += 10;
        if (expValue == 100)
            upLvlValue();
    }

    private void upLvlValue() {
        lvlValue += 1;
        expValue = 0;
    }

    public void reset() {
        lvlValue = 1;
        expValue = 0;
    }

    @Scheduled(fixedDelay = 5000)
    public void cleanUpTime() {
        cleanUp = true;
        System.out.println("cleanUp");
    }

    @Scheduled(fixedDelay = 12000)
    public void washDogTime() {
        washDog = true;
        System.out.println("washDog");
    }
}
