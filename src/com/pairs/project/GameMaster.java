package com.pairs.project;

import com.pairs.project.service.StrategyService;

import java.util.*;
import java.util.stream.Stream;

public class GameMaster implements StrategyService {
    private List<Player> scoreBoard = new ArrayList<>();

    private List<Player> players = new ArrayList<>();
    private Deck deck;
    private int numOfPlayers = 3;

    public GameMaster(Deck deck) {
        this.deck = deck;

        initPlayers();
    }

    public void getNumberofPlayers() {
        Scanner scan = new Scanner(System.in);
        numOfPlayers = scan.nextInt();
    }

    public List<Player> getPlayers() {
        return players;
    }


    public List<Card> dealHands() {
        //return the top two of shuffled deck
        return deck.getTwoCards();
    }

    public void initPlayers() {

        if (numOfPlayers < 1 || numOfPlayers > 6) {
            try {
                throw new Exception("The number of players should more than 1 but less than 6");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                System.exit(0);
            }
        }
        //defaults to 3 players per game
        Strategy defaultStrategy = Strategy.DEFAULT;
        for (int i=0; i<numOfPlayers; i++){
            players.add(new Player(defaultStrategy));
        }
        //deal hands for each player
        players.forEach(p -> {
            p.receiveCards(dealHands());
        });
    }

    public List<Player> getScoreBoard() {
        return scoreBoard;
    }

    public void applyStrategy() {

        players.stream().filter(p -> p.getStatus() == Status.ACTIVE).forEach(p -> {
//            if(p.getStrategy() == Strategy.DEFAULT)
            switch (p.getStrategy()) {
                case DEFAULT: {
                    if (p.totalPoints() < 17) {
                        var points = p.totalPoints();
                        hit(p);
                        System.out.println("Player " + p.getPlayerNumber() + " had " + points + " points and made a hit and got " + p.totalPoints() + " points");
                        if (p.totalPoints() >= 17 && p.totalPoints() <= 21) {
                            if (p.totalPoints() == 21)
                                win(p);
                            else
                                stick(p);

                        } else if (p.totalPoints() > 21)
                            goBust(p);

                    } else if (p.totalPoints() >= 17 && p.totalPoints() <= 21) {
                        //decide if he/she is a winner
                        if (p.totalPoints() == 21) {
                            win(p);
                        }
                        stick(p);
                    } else {
                        goBust(p);
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
        scoreBoard.add(player);
        System.out.println("ssss Player " + player.getPlayerNumber() + " decided to stick with " + player.totalPoints() + " points ssss");
        //player can't play again, bust him/her
        player.setStatus(Status.DONE);
    }

    @Override
    public void win(Player p) {
        //decide if he/she is a winner
        System.out.println("Player " + p.getPlayerNumber() + " won the game with " + p.totalPoints() + " points");
        System.exit(0);
    }

    @Override
    public void goBust(Player p) {
        //player can't play again, but him/her
        System.out.println("xxxx Player " + p.getPlayerNumber() + " just went bust with " + p.totalPoints() + " points xxxx");
        p.setStatus(Status.BUST);
    }

    @Override
    public void endGame() {
        if (scoreBoard.size() == 1) {
            System.out.println("\n ending game with only one onboard");
            var player = scoreBoard.get(0);
            System.out.println("Player " + player.getPlayerNumber() + " won the game with " + player.totalPoints() + " points");
        } else if (scoreBoard.size() > 1) {
            System.out.println("ending game with more players onboard");
            System.out.println(scoreBoard);
            var player = scoreBoard.stream().sorted(Comparator.comparingInt(Player::totalPoints).reversed()).toList().get(0);
//            var player = scoreBoard.get(0);
            System.out.println("Player " + player.getPlayerNumber() + " won the game with " + player.totalPoints() + " points");
        } else {
            System.out.println("Game ended with no one winning");
        }

        System.exit(0);
    }

    @Override
    public void playGame() {
        while (players.stream().filter(p -> p.getStatus() == Status.ACTIVE).count() > 0) {
            applyStrategy();
        }
        endGame();
    }
}
