package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void getSuit() {
        Card card = new Card("Spades","A");
        String expected = "Spades";
        card.flip();
        assertEquals(expected, card.getSuit());
    }

    @Test
    void getValue() {
        Card card = new Card("Spades","A");
        String value = "A";
        card.flip();
        assertEquals(value, card.getValue());
    }

    @Test
    void getPointValue() {
        Card card = new Card("Spades","A");
        int expected = 11;
        card.flip();
        assertEquals(expected,card.getPointValue());

    }

    @Test
    void getCount() {
        Card ace = new Card("Spades","A");
        Card seven = new Card("Hearts", "7");
        Card two = new Card("Diamonds", "2");
        int expectedAceCount = -1;
        int expectedSevenCount = 0;
        int expectedTwoCount = 1;

        assertEquals(expectedAceCount,ace.getCount());
        assertEquals(expectedSevenCount,seven.getCount());
        assertEquals(expectedTwoCount,two.getCount());

    }
}