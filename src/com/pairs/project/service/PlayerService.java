package com.pairs.project.service;

import com.pairs.project.Card;

import java.util.List;

public interface PlayerService {
    public void receiveCards(List<Card> cards);
    public List<Card> getCardsInHand();
}
