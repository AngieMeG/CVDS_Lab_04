package hangman.model;

/**
 * Bonus scheme to puntuate the hangman game
 * 1. The initial score is 0 points
 * 2. The correct attempts are bonificated with 10 points
 * 3. The incorrect attempts are penalizated with 5 points
 * 4. The minimal score is 0 points
 * 
 * @author Angie Medina
 * @author Jose Perez
 * @version 1.0 11/02/21
 */

public class BonusScore implements GameScore{

    private final int initialPoints = 0;
    private final int bonificationPoints = 10;
    private final int penalizationPoints = 5;
    private final int minimumScore =  0;

    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException{
        if (correctCount < 0 || incorrectCount < 0){
            throw new GameScoreException(GameScoreException.NEGATIVE_COUNT);
        }
        int score = initialPoints + (bonificationPoints * correctCount) - (penalizationPoints * incorrectCount);
        return score < minimumScore ? minimumScore : score;
    }

    public int getInitialPoints(){
        return initialPoints;
    }
}