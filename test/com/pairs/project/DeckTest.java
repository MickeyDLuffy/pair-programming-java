package com.pairs.project;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    Deck deck;

//    @BeforeEach
    public  void init() {
         deck = new Deck();
    }

   @Test
    public void createDeckTest() {
       deck = new Deck();
       deck.getCards().stream().peek(System.out::println).toList();

   }
}