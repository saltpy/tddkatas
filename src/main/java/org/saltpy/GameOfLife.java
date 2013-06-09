package org.saltpy;

public class GameOfLife {
    private boolean[][] state;
    private int x;
    private int y;

    public GameOfLife(boolean[][] initialState) {
        this.state = initialState;
        this.x = initialState[0].length;
        this.y = initialState.length;
    }

    public void advance() {
        boolean[][] newState = new boolean[this.y][this.x];
        for (int y = 0; y < this.y; y++) {
            for (int x = 0; x < this.x; x++) {
                int livingNeighbours = getLivingNeighbours(x, y);
                if (livingNeighbours == 3 || (this.state[y][x] && livingNeighbours == 2)) {
                    newState[y][x] = true;
                } else {
                    newState[y][x] = false;
                }
            }
        }
        this.state = newState;
    }

    private int getLivingNeighbours(int x, int y) {
        int livingNeighbours = 0;
        boolean[] neighbours = { getValueOfCell(x, y -1),
                                 getValueOfCell(x + 1, y -1),
                                 getValueOfCell(x + 1, y),
                                 getValueOfCell(x + 1, y + 1),
                                 getValueOfCell(x, y + 1),
                                 getValueOfCell(x - 1, y + 1),
                                 getValueOfCell(x - 1, y),
                                 getValueOfCell(x - 1, y - 1)};
        for (boolean neighbour : neighbours) {
            if (neighbour) {
                livingNeighbours++;
            }
        }
        return livingNeighbours;
    }

    private boolean getValueOfCell(int x, int y) {
        try {
            return state[y][x];
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < this.y; y++) {
            for (int x = 0; x < this.x; x++) {
                sb.append(state[y][x] ? '*' : '.');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
