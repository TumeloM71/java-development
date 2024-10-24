package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;
    public Hand(){
        cards = new ArrayList<>();
    }
    // A Card is dealt to the Hand and the Hand is responsible
    // to store the card
    public void deal(Card card){
        cards.add(card);
    }
    public int getSize(){
        return cards.size();
    }
    // The Hand uses the methods of each card to determine
// the value of each card - and adds up all values
    public int getValue(){
        boolean hasAce = false;
        int value = 0;
        for(Card card: cards){
            card.flip(); // turn the card over to see the value
            if ( card.getValue().equalsIgnoreCase("A") )
                hasAce = true;

            value += card.getPointValue();
            card.flip(); // hide the card again
        }
        if ( hasAce && value>21)  //Ace can be 1 or 11(default) value
            return value-10;      //If the player busts with an Ace of 11, this changes it to a value of 1
        else
            return value;
    }

    @Override
    public String toString() {
        return "Hand{" +
                 cards +
                '}'+", Value("+this.getValue()+")";
    }
}
