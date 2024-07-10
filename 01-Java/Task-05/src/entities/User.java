package entities;

import java.util.HashMap;

public class User {
    private String name = "DEV";
    private int ram = 0;
    private int victory = 0;
    private HashMap<String, Integer> pocket = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getVictory() {
        return victory;
    }

    public void setVictory(int victory) {
        this.victory = victory;
    }

    public void insertionOfPotion() {

    }

}
