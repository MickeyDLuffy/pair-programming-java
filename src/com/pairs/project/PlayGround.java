package com.pairs.project;

import java.util.stream.Stream;

public class PlayGround implements PlayStrategyInterface{
    @Override
    public void hit(){
        
    }

    @Override
    public void stick() {
              
    }

    @Override
    public void initialShuffle() {
        Stream.of(CardType.values())
                .peek(System.out::println).count();
    }
    
}
