package hangman.model;

/**
 * Exceptio class to the GameScore class
 * @author Angie Medina
 * @author Jose Perez
 * @version 1.0 11/02/21
 */

public class GameScoreException extends Exception {
    public static final String NEGATIVE_COUNT = "The attempt count is negative.";

    public GameScoreException(String message){
        super(message);
    }

}