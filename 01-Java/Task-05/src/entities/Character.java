package entities;

import services.CharacterService;

public abstract class Character implements CharacterService {

    private int hitPoints;
    private int strength;
    private String name;

    public Character(int hitPoints, int strength) {
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public abstract String getName();

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
}
