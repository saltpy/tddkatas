package org.saltpy;

public class BowlingGame {
    private int[] pins = new int[21];
    private int rolls = 0;

    public void roll(int pins) {
        this.pins[rolls] = pins;
        rolls++;
    }

    public int score() {
        int score = 0;
        int i = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (pins[i] == 10) {
                score += 10 + pins[i + 1] + pins[i + 2];
                i++;
            } else if (pins[i] + pins[i + 1] == 10) {
                score += 10 + pins[i + 2];
                i += 2;
            } else {
                score += pins[i] + pins[i + 1];
                i += 2;
            }
        }
        return score;
    }
}
