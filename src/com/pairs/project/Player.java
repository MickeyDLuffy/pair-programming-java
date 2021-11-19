package com.pairs.project;

import com.pairs.project.service.PlayerService;

import java.util.ArrayList;
import java.util.List;

public class Player implements PlayerService {
    public Strategy getStrategy() {
        return strategy;
    }

    private Strategy strategy = Strategy.DEFAULT;
    private Status status = Status.ACTIVE;
    private List<Card> cardsInHand = new ArrayList<>();

    public Player(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public String toString() {
        return "Player{" +
                "strategy=" + strategy +
                ", cardsInHand=" + cardsInHand +
                '}';
    }

    public int totalPoints() {
        if (cardsInHand.isEmpty()) {
            return 0;
        }
        return cardsInHand.stream()
                .map(Card::getValue)
                .map(CardValue::getValue)
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Override
    public void receiveCards(List<Card> cards) {
         cardsInHand.addAll(cards);
    }

    @Override
    public List<Card> getCardsInHand() {
        return cardsInHand;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
