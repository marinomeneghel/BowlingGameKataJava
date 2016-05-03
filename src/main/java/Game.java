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
            if(isStrike(frameIndex)) {
                score += strikeBonus(frameIndex);
                frameIndex += 1;
            } else if (isSpare(frame)) {
                score += spareBonus(frameIndex);
                frameIndex += 2;
            }  else {
                score += rolls[frameIndex] + rolls[frameIndex + 1];
                frameIndex += 2;
            }
        }
        return score;
    }

    private int strikeBonus(int frameIndex) {
        return 10 + rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private int spareBonus(int frameIndex) {
        return 10 + rolls[frameIndex + 2];
    }

    private boolean isSpare(int frame) {
        return rolls[frame] + rolls[frame + 1] == 10;
    }
}
