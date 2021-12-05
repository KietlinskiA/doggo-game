package pl.kietlinski.projektjava;

import lombok.Data;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
@Component
public class Dog {
    private int lvlValue;
    private int expValue;
    private boolean cleanUp;
    private boolean washDog;
    private String dogInfo;

    public Dog() {
        this.lvlValue = 1;
        this.expValue = 0;
        this.cleanUp = false;
        this.washDog = false;
        dogInfo = " ";
    }

    public void upExpValue() {
        expValue += 10;
        if (expValue == 100)
            upLvlValue();
    }

    private void upLvlValue() {
        lvlValue += 1;
        expValue = 0;
        setDogInfo("Twój piesek awansował!");
    }

    public void doCleanUp() {
        cleanUp = false;
        setDogInfo("Posprzątane!");
    }

    public void cleanUpTime() {
        cleanUp = true;
        setDogInfo("Musisz posprzątać!");
    }

    public void doWashDog() {
        washDog = false;
        setDogInfo("Piesek umyty!");
    }

    @Scheduled(fixedDelay = 2000)
    public void washDogTime() {
        washDog = true;
        setDogInfo("Musisz go umyć!");
    }

}
