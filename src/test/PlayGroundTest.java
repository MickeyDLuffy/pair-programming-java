package test;
import com.pairs.project.PlayGround;
import org.junit.jupiter.api.Test;

class PlayGroundTest {
    @Test
    void testInitialShuffle(){
        PlayGround play = new PlayGround();
        System.out.println("hello");
        play.initialShuffle();
    }
}