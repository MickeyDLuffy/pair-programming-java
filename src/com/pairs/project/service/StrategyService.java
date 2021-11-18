package com.pairs.project.service;

import com.pairs.project.Card;
import com.pairs.project.Deck;

import java.util.List;

public interface StrategyService {
    public void hit(Deck deck);
    public void stick(List<Card> cards);
    public default void goBust() {

    }
}
