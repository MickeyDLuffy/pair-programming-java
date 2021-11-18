package com.pairs.project;

import java.util.stream.Stream;

public enum CardType {
   HEARTS, DIAMONDS, CLUBS, SPADES;

   public static Stream<CardType> stream() {
      return Stream.of(CardType.values());
   }
}
