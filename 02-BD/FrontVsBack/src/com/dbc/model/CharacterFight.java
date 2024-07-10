package com.dbc.model;

import com.dbc.service.CharacterFightService;

public abstract class CharacterFight implements CharacterFightService {

    private int hitPoints;
    private int strength;
    private String name;
    private String playerHead;


    public CharacterFight(int hitPoints, int strength) {
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public CharacterFight() {
    }

    public String getName() {
        return this.name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrenght() {
        return strength;
    }

    public void setStrenght(int strength) {
        this.strength = strength;
    }

    public abstract boolean deduceHitPoints(int damage);

    public abstract boolean dodge();

    public String getPlayerHead() { return playerHead;}

    public abstract int getId();
}
