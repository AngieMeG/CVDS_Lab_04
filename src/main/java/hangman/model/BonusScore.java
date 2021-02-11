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
 * @version 11/02/21
 */

public class BonusScore implements GameScore{

    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException{
    }
}