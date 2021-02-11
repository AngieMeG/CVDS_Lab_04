package hangman.model; 

/**
 * Interface class that intends to calculate the score
 * @author Angie Medina
 * @author Jose Perez
 * @version 1.0 11/02/21
 */
public interface GameScore{

    /**
     * Calculates the match current score
     * @pre TRUE
     * @pos the match score calculated
     * @param correctCount, int the total of correct attempts of the player
     * @param incorrectCount, int the total of incorrect attempts of the player
     * @throws GameScoreException, NEGATIVE_VALUE, When one of the attempts count is negative
     */
    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException;
}