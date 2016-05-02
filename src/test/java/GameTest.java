import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void test_gutter_game() throws Exception {
        rollMany(20, 0);

        assertEquals(0, game.score());
    }

    @Test
    public void test_all_ones() throws Exception {
        rollMany(20, 1);

        assertEquals(20, game.score());
    }

    private void rollMany(int rolls, int pins) {
        for(int i = 0; i<rolls; i++) {
            game.roll(pins);
        }
    }
}
