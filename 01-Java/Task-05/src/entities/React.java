package entities;

import java.util.Random;

public class React extends Character {

    String name = "Java";
    int lucky = 1;

    public React(int hitPoints, int strength, String name) {
        super(hitPoints, strength);
        this.name = name;
    }

    public React(int hitPoints, int strength, String name, int lucky) {
        super(hitPoints, strength);
        this.name = name;
        this.lucky = lucky;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLucky() {
        return lucky;
    }

    @Override
    public void deduceHitPoints(int damage) {
        if (dodge()){
            System.out.println("ERROU!");
        } else {
            super.setHitPoints(getHitPoints() - damage);
        }

    }

    @Override
    public boolean dodge() {
        Random random = new Random();
        int randomNum = random.nextInt(10) ; // Gera número de 0 a 10 (e soma +1 para ser de 1 a 10)
        randomNum -= getLucky();

        if (randomNum <= 2) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int lightAttack(int strength) {
        return 0;
    }

    @Override
    public int heavyAttack(int strength) {
        return 0;
    }

    @Override
    public int specialAttack(int strength) {
        return 0;
    }
}
