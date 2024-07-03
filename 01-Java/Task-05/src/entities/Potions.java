package entities;

public class Potions {
    private String name;
    private boolean active;

    public void power(int level){};

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
