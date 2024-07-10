package com.dbc.model;

import java.util.Random;

public class Java extends CharacterFight {

    String name = "Java";
    private String playerHead = "(⌐■_■)";
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
        int randomNum = random.nextInt(10) ;

        if (randomNum <= 2) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int lightAttack(int strength) {
       return strength += forcaExtra;
    }

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
}
