package com.pairs.project.service;

import com.pairs.project.Card;
import com.pairs.project.Deck;
import com.pairs.project.Player;

import java.util.List;

public interface StrategyService {
    public void hit(Player player);
    public void stick(Player player);
    public void endGame();
    public void playGame();
}
