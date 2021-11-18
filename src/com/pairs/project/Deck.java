package com.pairs.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck implements Shuffleable {
    private List<Card> cards;



    public Deck() {
        cards = new ArrayList<>();
        createDeck();
    }

    /**
     * Populates deck with default 52 cards
     */
    private void createDeck() {
        CardType.stream()
                .peek(suit -> {
                    CardValue.stream()
                            .forEach(value -> this.cards.add(new Card(suit, value)));
                }).toList();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }
}