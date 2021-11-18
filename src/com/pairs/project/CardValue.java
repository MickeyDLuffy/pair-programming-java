package com.pairs.project;

import java.util.stream.Stream;

public enum CardValue {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ACE(11);

    private final int value;
    CardValue(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    public static Stream<CardValue> stream() {
        return Stream.of(CardValue.values());
    }
}
