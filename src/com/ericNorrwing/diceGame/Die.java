package com.ericNorrwing.diceGame;

public class Die {
    private int value;
    private int sides;
    private boolean saved;

    public Die(int value, int sides) {
        this.value = value;
        this.sides = sides;
    }

    public Die() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
