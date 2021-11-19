package com.pairs.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    Deck deck = new Deck();

    GameMaster gameMaster = new GameMaster(deck);

    @Test
    public void testTotalPoints() {
        gameMaster.initPlayers(); //create players and deal hands
        gameMaster.getPlayers().stream().forEach(System.out::println);//does it print show players and their two cards

        var firstPlayer = gameMaster.getPlayers().get(0);
        //always a player would have a card in hand and hence a value(totalPoints)
        //so assert that the totalPoint not equals 0
        Assertions.assertNotEquals(0, firstPlayer.totalPoints(), firstPlayer + " A player didn't have a card in hand");

    }
}
