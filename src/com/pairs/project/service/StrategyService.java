package com.pairs.project.service;

import com.pairs.project.Card;

import java.util.List;

public interface StrategyService {
    public void hit(List<Card> cards);
    public void stick(List<Card> cards);
    public default void goBust() {

    }
}
