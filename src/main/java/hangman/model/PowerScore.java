package hangman.model;

/**
 * Power scheme to puntuate the hangman game
 * 1. The initial score is 0 points
 * 2. The correct i-th correct word is bonificated with 5^i
 * 3. The incorrect attempts are penalizated with 8 points
 * 4. The minimal score is 0 points
 * 5. If the score surpass 500 points, the score is 500 points
 * 
 * @author Angie Medina
 * @author Jose Perez
 * @version 1.0 11/02/21
 */

public class PowerScore implements GameScore{

    private final int initialPoints = 0;
    private final int bonificationPoints = 5;
    private final int penalizationPoints = 8;
    private final int minimumScore =  0;
    private final int maximumScore = 500;

    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException{
        int score = initialPoints;
        if (correctCount < 0 || incorrectCount < 0){
            throw new GameScoreException(GameScoreException.NEGATIVE_COUNT);
        }
        for (int i = 0; i < correctCount; i++) score += Math.pow(bonificationPoints, i + 1);

        score = score - (penalizationPoints * incorrectCount) < minimumScore ? minimumScore : score - (penalizationPoints * incorrectCount);
        return score > maximumScore ? maximumScore : score;
    }
}