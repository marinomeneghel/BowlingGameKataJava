public class Game {

    private int[] rolls = new int[20];
    private int currentRoll;

    void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    int score() {
        int score = 0;
        int frameIndex= 0;
        for (int frame=0; frame<10; frame++) {
            if (rolls[frame] + rolls[frame + 1] == 10) { // spare
                score += rolls[frameIndex] + rolls[frameIndex + 1] + rolls[frameIndex + 2];
            } else {
                score += rolls[frameIndex] + rolls[frameIndex + 1];
            }
            frameIndex += 2;
        }
        return score;
    }
}
