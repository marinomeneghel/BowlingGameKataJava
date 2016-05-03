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

    @Test
    public void test_one_spare() throws Exception {
        rollSpare();
        rollMany(18, 1);

        assertEquals(29, game.score());
    }

    @Test
    public void test_one_strike() throws Exception {
        rollStrike();
        game.roll(5);
        rollMany(17, 1);
        assertEquals(38, game.score());
    }

    @Test
    public void test_strike_and_spare() throws Exception {
        rollStrike();
        rollSpare();
        rollMany(16, 1);
        assertEquals(47, game.score());
    }

    @Test
    public void test_all_strikes() throws Exception {
        rollMany(20, 10);
        assertEquals(300, game.score());
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollMany(int rolls, int pins) {
        for(int i = 0; i<rolls; i++) {
            game.roll(pins);
        }
    }
}
