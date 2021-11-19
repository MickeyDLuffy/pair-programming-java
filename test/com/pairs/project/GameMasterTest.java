package com.pairs.project;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;


class GameMasterTest {
    Deck deck = new Deck();

    GameMaster gameMaster = new GameMaster(deck);

    @Test
    void testInitialShuffle() {
        //pick a card type at random
        //pick a value related to that card at random
        //assign it to a player
        Stream.of(CardType.values())
                .forEach(x -> System.out.println(x));
    }

    @Test
    public void initPlayers() {
        gameMaster.getPlayers().stream().forEach(System.out::println);//does it print show players and their two cards
    }

    @Test
    public void testApplyStrategy() {
        gameMaster.applyStrategy();
        System.out.println("==============================================================\n");
        gameMaster.getPlayers().stream().forEach(System.out::println);//does it print show players and their two cards
    }

    @Test
    public void testPlayGame(){

    }
}