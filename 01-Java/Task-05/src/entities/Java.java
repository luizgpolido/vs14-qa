package entities;

import java.util.Random;

public class Java extends Character {

    String name = "Java";
    private String playerHead = "(⌐■_■)";
    private String deadHead = "(⌐X_X)";
    int forcaExtra = 1;

    public Java(int hitPoints, int strenght, String name) {
        super(hitPoints, strenght);
        this.name = name;
    }

    public Java(int hitPoints, int strenght, String name, int forcaExtra) {
        super(hitPoints, strenght);
        this.name = name;
        this.forcaExtra = forcaExtra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean deduceHitPoints(int damage) {
        if (!dodge()){
            if (damage > getHitPoints()) {
                super.setHitPoints(0);
            } else {
                super.setHitPoints(getHitPoints() - damage);
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

        if (randomNum <= 2) {
            //System.out.println(getName() + ": Desviou do ataque inimigo!");
            // Caso tenha bebido a poção, aumenta a chance de desviar por 3 seg
            return true;
        } else {
            //System.out.println(getName() + ": Não conseguiu desviar!");
            return false;
        }
    }

    //Quando o combo mais forte for acertado ele
    @Override
    public int lightAttack(int strength) {
       return strength += forcaExtra;
    }
    //poção de coffee aumenta a força

    @Override
    public int heavyAttack(int strength) {
        Random random = new Random();
        int randomNum = random.nextInt(10) + 1;

        if ((randomNum <= 5)){
            return strength = (strength * 2) + forcaExtra;

        }
        return 0;
    }

    @Override
    public int specialAttack(int strength) {
        boolean success;
        Random random = new Random();
        int randomNum = random.nextInt(10) + 1;

        if ((randomNum <= 2)){
            return strength = (strength * 2) + forcaExtra;
        }
        return 0;

    }

    public String getPlayerHead() { return playerHead;}
    public String getDeadHead() {return deadHead;}
}
