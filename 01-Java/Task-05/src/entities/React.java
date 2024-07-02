package entities;

import java.util.Random;

public class React extends Character {

    String name = "React";
    private String playerHead = "(ಠ益ಠ)";

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
    public boolean deduceHitPoints(int damage) {
        if (!dodge()){
            super.setHitPoints(getHitPoints() - damage);
            if(super.getHitPoints() < 0){
                super.setHitPoints(0);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean dodge() {
        Random random = new Random();
        int randomNum = random.nextInt(10) ; // Gera número de 0 a 10 (e soma +1 para ser de 1 a 10)
        randomNum -= getLucky();

        if (randomNum <= 2) {
            //System.out.println(getName() + ": Desviou do ataque inimigo!");
            return true;
        } else {
            //System.out.println(getName() + ": Não conseguiu desviar!");
            return false;
        }
    }

    @Override
    public int lightAttack(int strength) {
        return strength;
    }

    @Override
    public int heavyAttack(int strength) {
        return strength * 2;
    }

    @Override
    public int specialAttack(int strength) {
        return strength * 3;
    }

    public String getPlayerHead() { return playerHead;}
}
