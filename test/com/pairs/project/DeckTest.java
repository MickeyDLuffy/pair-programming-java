package com.pairs.project;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    Deck deck = new Deck();
    ;

    //    @BeforeEach
    public void init() {
        deck = new Deck();
    }

    @Test
    public void createDeckTest() {
        deck.getCards().stream().peek(System.out::println).toList();

    }

    @Test
    public void shuffleTest() {
        //before we shuffle we pop card
        var hashForInitialTopCard = deck.getCards().get(0).hashCode();
        System.out.println("Hashcode for topmost card before shuffle: "+hashForInitialTopCard);
        deck.shuffle();
        var hashForLaterTopCard = deck.getCards().get(0).hashCode();
        System.out.println("Hashcode for topmost card after shuffle: "+hashForLaterTopCard);

        //test that it passes because deck has been shuffled
        assertNotEquals(hashForInitialTopCard, hashForLaterTopCard);
    }

    @Test
    public void popCardTest() {
        //pop card
        deck.popCard();
        //assert that new length of deck is 1 less of the original deck length
        assertEquals(51, deck.getCards().size(), "Failed to pop card so length of deck remains the same");
//        System.out.println(deck.popCard());
    }

    @Test
    public void getTwoCardsTest() {
        assertEquals(2, deck.getTwoCards().size());
    }


}