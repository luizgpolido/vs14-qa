package com.dbc.model;

import java.util.Random;

public class NPC extends CharacterFight {

    String name = "Portugol";

    public NPC(int hitPoints, int strenght, String name) {
        super(hitPoints, strenght);
        this.name = name;
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
