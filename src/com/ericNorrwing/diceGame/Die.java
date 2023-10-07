package com.ericNorrwing.diceGame;

public class Die {
    private int value;
    private int sides;
    private boolean saved;

    //Constructor for dice, does not include "saved" because its modified by getters and setters and boolean default is false
    public Die(int value, int sides) {
        this.value = value;
        this.sides = sides;
    }

    //Getters/Setters for most values in Die
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSides() {
        return sides;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }


    //a simple toString override to ensure nice outputs whenever you print Die
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
