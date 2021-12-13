package pl.kietlinski.projektjava;

import lombok.Data;

@Data
public class Dog {
    private int lvlValue;
    private int expValue;
    private boolean washedOut;
    private boolean fed;
    private boolean cleanedUp;
    private String dogInfo;

    public Dog() {
        this.lvlValue = 1;
        this.expValue = 0;
        this.washedOut = false;
        this.fed = false;
        this.cleanedUp = false;
        dogInfo = " ";
    }

    public void upExpValue(int exp) {
        expValue += exp;
        if (expValue >= 100)
            upLvlValue();
    }

    private void upLvlValue() {
        lvlValue += 1;
        expValue = expValue - 100;
        dogInfo = "Twój piesek awansował!";
    }

    public void doWashOut() {
        dogInfo = "Piesek umyty!";
        washedOut = true;
    }

    public void washTime() {
        dogInfo = "Musisz go umyć!";
        washedOut = false;
    }

    public void doFeed() {
        dogInfo = "Piesek nakarmiony!";
        fed = true;
    }

    public void feedTime() {
        dogInfo = "Musisz go nakarmić!";
        fed = false;
    }

    public void doCleanUp() {
        setDogInfo("Posprzątane!");
        cleanedUp = true;
    }

    public void cleanUpTime() {
        setDogInfo("Musisz posprzątać!");
        cleanedUp = false;
    }

}
