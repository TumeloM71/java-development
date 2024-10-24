package com.pluralsight;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @org.junit.jupiter.api.Test
    void shuffle() {
        //Before shuffle
        Deck deck = new Deck();
        System.out.println("Before shuffle: ");
        for (Card card : deck.getCards())
            System.out.println(card);

        //After shuffle
        System.out.println();
        System.out.println("After shuffle: ");
        deck.shuffle();
        for (Card card : deck.getCards())
            System.out.println(card);


    }

    @org.junit.jupiter.api.Test
    void deal() {
        Deck deck = new Deck();
        Hand hand = new Hand();

        Card card = deck.deal();
        hand.deal(card);
        int sizeAfterDealing = 51;

        assertEquals(51,deck.getSize()) ;
        assertFalse(deck.getCards().contains(card));

    }

    @org.junit.jupiter.api.Test
    void getSize() {
        Deck deck = new Deck();
        int expectedSize = 52;

        assertEquals(expectedSize,deck.getSize());

    }
}