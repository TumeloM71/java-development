package com.pluralsight;

public class Card {
    private final String suit;
    private final String value;
    private boolean isFaceUp;
    boolean isNumeric;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.isFaceUp = false;
        this.isNumeric = value.chars().allMatch(Character::isDigit);
    }
    public String getSuit(){
// only return the suit if the card is face up
        if(isFaceUp){
            return suit;
        } else {
            return "#";
        }
    }
    public String getValue(){
// only return the value if the card is face up
        if(isFaceUp){
// this is the string value of the card
// i.e. A, K, Q, J, 10, 9 ...
            return value;
        } else {
            return "#";
        }
    }
    public int getPointValue(){
// only return the value if the card is face up
        if(isFaceUp){
// determine point value and return it
            if (value.equals("A"))  // A = 11
                return 11;
            else if (this.isNumeric)
                return Integer.parseInt(value); // all numeric cards are equal to their face value
            else
                return 10; // K, Q, J = 10
        } else {
            return 0;
        }
    }
    public boolean isFaceUp(){
        return isFaceUp;
    }
    public void flip(){
        isFaceUp = !isFaceUp;
    }

    public int getCount(){
        this.isFaceUp = true;
        if (this.getPointValue()<7) {
            this.isFaceUp = false;
            return 1;
        }
        else if(this.getPointValue()>9) {
            this.isFaceUp = false;
            return -1;
        }
        else {
            this.isFaceUp = false;
            return 0;
        }
    }

    @Override
    public String toString() {
        return  value + " of " + suit;

    }
}
