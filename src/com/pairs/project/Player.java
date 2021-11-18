package com.pairs.project;

import com.pairs.project.service.StrategyService;

import java.util.List;

public class Player implements StrategyService {
    private Strategy strategy = Strategy.DEFAULT;
    private List<Card> cardsInHand;

    public Player(Strategy strategy) {
        this.strategy = strategy;
    }


    public int totalPoints() {
        if(cardsInHand.isEmpty()) {
            return 0;
        }
        return cardsInHand.stream()
                .map(Card::getValue)
                .map(CardValue::getValue)
                .mapToInt(Integer::intValue)
                .sum();
    }


    @Override
    public void hit(Deck deck) {
        if(totalPoints() < 17) {

        }
    }

    @Override
    public void stick(List<Card> cards) {

    }
}
