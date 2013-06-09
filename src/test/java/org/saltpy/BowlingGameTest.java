package org.saltpy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {
    private BowlingGame game;

    @Before
    public void setUp() {
        game = new BowlingGame();
    }

    @Test
    public void gutterGame() {
        rollMany(20, 0);
        Assert.assertEquals(0, game.score());
    }

    @Test
    public void allOnes() {
        rollMany(20, 1);
        Assert.assertEquals(20, game.score());
    }

    @Test
    public void oneSpare() {
        game.roll(5);
        game.roll(5);
        game.roll(1);
        Assert.assertEquals(12, game.score());
    }

    @Test
    public void oneStrike() {
        game.roll(10);
        game.roll(3);
        game.roll(4);
        Assert.assertEquals(24, game.score());
    }

    @Test
    public void perfectGame() {
        rollMany(12, 10);
        Assert.assertEquals(300, game.score());
    }

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }
}
