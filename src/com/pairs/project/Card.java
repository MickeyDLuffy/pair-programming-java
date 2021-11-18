package com.pairs.project;

public class Card {


    private final CardType suit;
    private final CardValue value;

    public Card(CardType suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public CardType getSuit() {
        return suit;
    }

    public CardValue getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", value=" + value +
                '}';
    }
}
