package pl.kietlinski.projektjava;

import lombok.Data;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Data
public class MainService {

    private Dog dog;
    private static int dogInfoTimer;
    private static int dirtTimer;
    private static int bowlTimer;
    private static int feetTimer;
    private String dirtVisibility;
    private String bowlFilling;
    private String feetVisibility;
    private static final String VISIBLE = "visible";
    private static final String HIDDEN = "hidden";
    private static final String BOWL_EMPTY = "img/bowl_empty.png";
    private static final String BOWL_FULL = "img/bowl_full.png";

    public MainService() {
        dog = new Dog();
        dirtVisibility = VISIBLE;
        bowlFilling = BOWL_EMPTY;
        feetVisibility = VISIBLE;
    }

    public void reset() {
        dog = new Dog();
    }

    public void doWashDog() {
        if(!dog.isWashedOut()){
            dog.doWashOut();
            dog.upExpValue(10);
            dirtVisibility = HIDDEN;
            dirtTimer = 0;
            dogInfoTimer = 0;
        }
    }

    public void doFeed() {
        if(!dog.isFed()){
            dog.doFeed();
            dog.upExpValue(5);
            bowlFilling = BOWL_FULL;
            bowlTimer = 0;
            dogInfoTimer = 0;
        }
    }

    public void doCleanUp() {
        if(!dog.isCleanedUp()) {
            dog.doCleanUp();
            dog.upExpValue(15);
            feetVisibility = HIDDEN;
            feetTimer = 0;
            dogInfoTimer = 0;
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void dogLifecycle() {
        if(dogInfoTimer == 3){
            dog.setDogInfo(" ");
        } else {
            dogInfoTimer++;
        }
        if(dirtTimer == 6){
            dog.washTime();
            dirtVisibility = VISIBLE;
        } else {
            dirtTimer++;
        }
        if(bowlTimer == 10){
            dog.feedTime();
            bowlFilling = BOWL_EMPTY;
        } else {
            bowlTimer++;
        }
        if(feetTimer == 20){
            dog.cleanUpTime();
            feetVisibility = VISIBLE;
        } else {
            feetTimer++;
        }
    }


}
