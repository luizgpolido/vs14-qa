package com.dbc.model;

import java.util.Random;

public class Portugol extends CharacterFight {

    String name = "Portugol";
    private String playerHead = "(ô_Ô) ?";
    int id;

    public Portugol(int hitPoints, int strenght, String name) {
        super(hitPoints, strenght);
        this.name = name;
        this.id = 1003;
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
        int randomNum = random.nextInt(10) ; // Gera número de 0 a 10 (e soma +1 para ser de 1 a 10)

        if (randomNum <= 2) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int lightAttack(int strength) {
        return strength;
    }

    @Override
    public int heavyAttack(int strength) {
        Random random = new Random();
        int randomNum = random.nextInt(10) + 1;

        if ((randomNum <= 3)){
            return strength = (strength * 2);

        }
        return 0;
    }

    @Override
    public int specialAttack(int strength) {
        boolean success;
        Random random = new Random();
        int randomNum = random.nextInt(10) + 1;

        if ((randomNum <= 1)){
            System.out.println("\n\"Portugês: Oops, pseudo código nem é linguagem! Te curei sem querer\"\n\n");
            return -1;
        } else {
            return 3;
        }
    }

    public String getPlayerHead() { return playerHead;}
}
