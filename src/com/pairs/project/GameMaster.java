package com.pairs.project;

import com.pairs.project.service.StrategyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class GameMaster implements StrategyService {
    private List<Map<Player, Integer>> scoreBoard = new ArrayList<>();



    private List<Player> players = new ArrayList<>();
    private Deck deck;

    public GameMaster(Deck deck) {
        this.deck = deck;

        initPlayers();
    }

    public List<Player> getPlayers() {
        return players;
    }


    public List<Card> dealHands() {
        //return the top two of shuffled deck
        return deck.getTwoCards();
    }

    public void initPlayers() {
        //defaults to 3 players per game
        Strategy defaultStrategy = Strategy.DEFAULT;
        players.addAll(List.of(new Player(defaultStrategy), new Player(defaultStrategy), new Player(defaultStrategy)));

        //deal hands for each player
        players.forEach(p -> {
            p.receiveCards(dealHands());
        });

    }

    public List<Map<Player, Integer>> getScoreBoard() {
        return scoreBoard;
    }

    public void applyStrategy() {
        players.forEach(p -> {
//            if(p.getStrategy() == Strategy.DEFAULT)
            switch (p.getStrategy()) {
                case DEFAULT: {
                    if (p.totalPoints() < 17) {
                        hit(p);
                    }
                    else if(p.totalPoints() >=17 && p.totalPoints() <=21) {
                        //decide if he/she is a winner
                        if(p.totalPoints() ==21){
                            System.out.println("Player "+(players.indexOf(p)+1)+" won the game");
                            System.exit(0);
                        }
                        stick(p);
                    }else{
                        //player can't play again, but him/her
                        p.setStatus(Status.BUST);
                    }
                    break;
                }
            }
        });
    }

    @Override
    public void hit(Player player) {
        player.getCardsInHand().add(deck.popCard());
    }

    @Override
    public void stick(Player player) {
        //add player to scoreboard to await final decision
        scoreBoard.add(Map.of(player, player.totalPoints()));
        //player can't play again, bust him/her
        player.setStatus(Status.BUST);
    }

    @Override
    public void endGame() {
        if(scoreBoard.size() ==1){
            System.out.println(scoreBoard.get(0));
//            System.out.println("Player "+players.indexOf(scoreBoard.get(0).get(0))+1+" won the game");
        }

        System.exit(0);
    }

    @Override
    public void playGame() {
        while(players.stream().filter(p -> p.getStatus() == Status.ACTIVE).count() > 1){
            applyStrategy();
        }
        endGame();
    }
}
