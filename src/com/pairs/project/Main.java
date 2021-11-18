package com.pairs.project;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var n = new ArrayList<>();
        CardValue.stream().map(type -> n.add(type.name()));
//        System.out.println(n);
        CardValue.stream().peek(cardValue -> System.out.println(cardValue.getValue())).toList();
	// write your code here
//      PlayGround playGround = n
//        Deck deck = new Deck(List.of(new Card(CardType.DIAMONDS, CardValue.FOUR)));
//        CardValue.stream().map(Enum::name).peek(System.out::println).toList();
    }
}
