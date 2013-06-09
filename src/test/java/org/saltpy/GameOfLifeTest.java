package org.saltpy;

import org.junit.Assert;
import org.junit.Test;

public class GameOfLifeTest {

    @Test
    public void liveCellWithTwoLiveNeighboursShouldSurvive() {
        boolean[][] initial = {{false, true, false},
                               {true, false, true},
                               {false, true, false}};
        String expected = ".*.\n" +
                          "*.*\n" +
                          ".*.\n";
        GameOfLife game = new GameOfLife(initial);
        game.advance();
        Assert.assertEquals(expected, game.toString());
    }

    @Test
    public void deadCellWithThreeLiveNeighboursShouldLive() {
        boolean[][] initial = {{false, true, false},
                               {true, true, false},
                               {false, false, false}};
        String expected = "**.\n" +
                          "**.\n" +
                          "...\n";
        GameOfLife game = new GameOfLife(initial);
        game.advance();
        Assert.assertEquals(expected, game.toString());
    }

    @Test
    public void livingCellWithFourNeighboursShouldDie() {
        boolean[][] initial = {{true, true, true},
                               {true, true, true}, 
                               {true, true, true}};
        String expected = "*.*\n" +
                          "...\n" +
                          "*.*\n";
        GameOfLife game = new GameOfLife(initial);
        game.advance();
        Assert.assertEquals(expected, game.toString());
    }

    @Test
    public void livingCellWithLessThanTwoNeighboursShouldDie() {
        boolean[][] initial = {{false, false, false},
                               {false, true, false},
                               {false, false, false}};
        String expected = "...\n" +
                          "...\n" +
                          "...\n";
        GameOfLife game = new GameOfLife(initial);
        game.advance();
        Assert.assertEquals(expected, game.toString());
    }

    @Test
    public void gliderPattern() {
        boolean[][] initial = {{false, false, true, false},
                               {true, false, true, false},
                               {false, true, true, false},
                               {false, false, false, false}};
        String expected = "....\n" +
                          "...*\n" +
                          ".*.*\n" +
                          "..**\n";
        GameOfLife game = new GameOfLife(initial);
        game.advance();
        game.advance();
        game.advance();
        game.advance();
        Assert.assertEquals(expected, game.toString());
    }
}
