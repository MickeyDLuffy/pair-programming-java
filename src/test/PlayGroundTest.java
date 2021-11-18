package test;
import com.pairs.project.CardType;
import com.pairs.project.PlayGround;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

class PlayGroundTest {
    @Test
    void testInitialShuffle(){
        //pick a card type at random
        //pick a value related to that card at random
        //assign it to a player
        Stream.of(CardType.values())
                .forEach(x->System.out.println(x));
    }
}