package com.pluralsight;

public class Player {
    String name;
    Hand hand;
    boolean canSeeCount;

    public Player(String name){
        this.name = name;
        this.hand = new Hand();
        this.canSeeCount = false;
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setCanSeeCount(boolean canSeeCount) {
        this.canSeeCount = canSeeCount;
    }

    @Override
    public String toString() {
        return name + ", " + hand;
    }
}
