package hangman;

import org.junit.Assert;
import org.junit.Test;

import hangman.model.GameScore;
import hangman.model.GameScoreException;
import hangman.model.OriginalScore;
import hangman.model.BonusScore;
import hangman.model.PowerScore;


/**
 * Test Class for GameScore
 * @author Angie Medina
 * @author Jose Perez
 * @version 1.0 11/02/21
 * 
 * -------------------------------------------------------------------------------------------------
 * ORIGINAL SCORE
 * 
 * Número                 Clase de Equivalencia                       Resultado
 *   1. 	                correctCount < 0 			               Invalid
 *   2. 	                incorrectCount < 0 			               Invalid
 *   3.	         correctCount >= 0 && incorrectCount > 10			      0 
 *   4.	         correctCount >= 0 && incorrectCount =< 10	    100 - incorrectCount * 10
 * 
 * BORDER CASES
 * Número                 Clase de Equivalencia                       Resultado
 *   1. 	                correctCount = -1 			               Invalid
 *   2. 	               incorrectCount = -1				           Invalid
 *   3.	         correctCount = 0 && incorrectCount = 11			      0 
 *   4.	         correctCount = 0 && incorrectCount = 10	              0
 * -------------------------------------------------------------------------------------------------
 * BONUS SCORE
 * 
 * Número                     Clase de Equivalencia                                Resultado
 *   1. 	                     correctCount < 0 			                        Invalid
 *   2. 	                    incorrectCount < 0				                    Invalid
 *   3.	   0 <= correctCount < 2 * incorrectCount && incorrectCount > 0		           0 
 *   4.	     correctCount >= 2 * incorrectCount && incorrectCount >= 0	  10*correctCount-5*incorrectCount
 * 
 * BORDER CASES
 * Número                      Clase de Equivalencia                              Resultado
 *   1. 	                     correctCount = -1 			                       Invalid
 *   2. 	                    incorrectCount = -1				                   Invalid
 *   3.	               correctCount = 0 && incorrectCount = 1		                  0  
 *   4.	               correctCount = 1 && incorrectCount = 0	                      10
 * ------------------------------------------------------------------------------------------------
 POWER SCORE

 * Número                          Clase de Equivalencia                                           Resultado
 *   1. 	                          correctCount < 0 			                                    Invalid
 *   2. 	                         incorrectCount < 0				                                Invalid
 *   3.	           (5 ^ (correctCount + 1) + 1) / 4 - 8 * incorrectCount < 0		                   0 
 *   4.	          (5 ^ (correctCount + 1) + 1) / 4 - 8 * incorrectCount > 500		                  500
 *   5.        0 =< (5 ^ (correctCount + 1) + 1) / 4 - 8 * incorrectCount =< 500	 5^(correctCount+1)+1/4-8*incorrectCount
 * 
 * BORDER CASES
 * Número                          Clase de Equivalencia                                           Resultado
 *   1. 	                         correctCount = -1 			                                    Invalid
 *   2. 	                        incorrectCount = -1				                                Invalid
 *   3.	                   correctCount = 1 && incorrectCount = 1		                               0 
 *   4.	                   correctCount - 4 && incorrectCount = 1		                              500
 *   5.                    correctCount = 1 && incorrectCount = 0                                       5
 */

public class GameScoreTest {

	private GameScore original = new OriginalScore();
	private GameScore bonus = new BonusScore();
	private GameScore power = new PowerScore();

	/**
	 * Original Score 1
	 */
	@Test	
	public void validateOriginalCorrectThrowException(){
		try{
			original.calculateScore(-10, 1);
			Assert.fail("Didn't Threw Exception.");
		}catch(GameScoreException e){
			Assert.assertEquals(GameScoreException.NEGATIVE_COUNT, e.getMessage());
		}
	}
	
	/**
	 * Original Score 1 Border
	 */
	@Test	
	public void validateOriginalCorrectBorderThrowException(){
		try{
			original.calculateScore(-1, 1);
			Assert.fail("Didn't Threw Exception.");
		}catch(GameScoreException e){
			Assert.assertEquals(GameScoreException.NEGATIVE_COUNT, e.getMessage());
		}
	}

	/**
	 * Original Score 2
	 */
	@Test	
	public void validateOriginalIncorrectThrowException(){
		try{
			original.calculateScore(1, -10);
			Assert.fail("Didn't Threw Exception.");
		}catch(GameScoreException e){
			Assert.assertEquals(GameScoreException.NEGATIVE_COUNT, e.getMessage());
		}
	}
	
	/**
	 * Original Score 2 Border
	 */
	@Test	
	public void validateOriginalIncorrectBorderThrowException(){
		try{
			original.calculateScore(1, -1);
			Assert.fail("Didn't Threw Exception.");
		}catch(GameScoreException e){
			Assert.assertEquals(GameScoreException.NEGATIVE_COUNT, e.getMessage());
		}
	}

	/**
	 * Original Score 3 
	 */
	@Test	
	public void validateOriginalScoreZero(){
		try{
			Assert.assertEquals(0,original.calculateScore(5, 15));
		}catch(GameScoreException e){
			Assert.fail("Threw Exception.");
		}
	}

	/**
	 * Original Score 3 Border
	 */
	@Test	
	public void validateOriginalBorderScoreZero(){
		try{
			Assert.assertEquals(0,original.calculateScore(0, 11));
		}catch(GameScoreException e){
			Assert.fail("Threw Exception.");
		}
	}

	/**
	 * Original Score 4
	 */
    @Test
    public void validateOriginalScore(){
		try{
			Assert.assertEquals(60,original.calculateScore(3, 4));
		}catch(GameScoreException e){
			Assert.fail("Threw Exception.");
		}
	}

	/**
	 * Original Score 4 Border
	 */
    @Test
    public void validateOriginalScoreBorder(){
		try{
			Assert.assertEquals(0,original.calculateScore(0, 10));
		}catch(GameScoreException e){
			Assert.fail("Threw Exception.");
		}
	}

    /* --------------------------------------------------------- BONUS SCORE --------------------------------------------------------- */

	/**
	 * Bonus Score 1
	 */
	@Test	
	public void validateBonusCorrectThrowException(){
		try{
			bonus.calculateScore(-10, 1);
			Assert.fail("Didn't Threw Exception.");
		}catch(GameScoreException e){
			Assert.assertEquals(GameScoreException.NEGATIVE_COUNT, e.getMessage());
		}
	}
	
	/**
	 * Bonus Score 1 Border
	 */
	@Test	
	public void validateBonusCorrectBorderThrowException(){
		try{
			bonus.calculateScore(-1, 1);
			Assert.fail("Didn't Threw Exception.");
		}catch(GameScoreException e){
			Assert.assertEquals(GameScoreException.NEGATIVE_COUNT, e.getMessage());
		}
	}

	/**
	 * Bonus Score 2
	 */
	@Test	
	public void validateBonusIncorrectThrowException(){
		try{
			bonus.calculateScore(1, -10);
			Assert.fail("Didn't Threw Exception.");
		}catch(GameScoreException e){
			Assert.assertEquals(GameScoreException.NEGATIVE_COUNT, e.getMessage());
		}
	}
	
	/**
	 * Bonus Score 2 Border
	 */
	@Test	
	public void validateBonusIncorrectBorderThrowException(){
		try{
			bonus.calculateScore(1, -1);
			Assert.fail("Didn't Threw Exception.");
		}catch(GameScoreException e){
			Assert.assertEquals(GameScoreException.NEGATIVE_COUNT, e.getMessage());
		}
	}

    /**
	 * Bonus Score 3 
	 */
	@Test	
	public void validateBonusScoreZero(){
		try{
			Assert.assertEquals(0,bonus.calculateScore(4, 4));
		}catch(GameScoreException e){
			Assert.fail("Threw Exception.");
		}
	}

	/**
	 * Bonus Score 3 Border
	 */
	@Test	
	public void validateBonusBorderScoreZero(){
		try{
			Assert.assertEquals(0,bonus.calculateScore(0, 1));
		}catch(GameScoreException e){
			Assert.fail("Threw Exception.");
		}
	}

	/**
	 * Bonus Score 4
	 */
    @Test
    public void validateBonusScore(){
		try{
			Assert.assertEquals(25,bonus.calculateScore(4, 3));
		}catch(GameScoreException e){
			Assert.fail("Threw Exception.");
		}
	}

	/**
	 * Bonus Score 4 Border
	 */
    @Test
    public void validateBonusScoreBorder(){
		try{
			Assert.assertEquals(10,bonus.calculateScore(1, 0));
		}catch(GameScoreException e){
			Assert.fail("Threw Exception.");
		}
	}

	/* --------------------------------------------------------- POWER SCORE --------------------------------------------------------- */

	/**
	 * Bonus Score 1
	 */
	@Test	
	public void validatePowerCorrectThrowException(){
		try{
			power.calculateScore(-10, 1);
			Assert.fail("Didn't Threw Exception.");
		}catch(GameScoreException e){
			Assert.assertEquals(GameScoreException.NEGATIVE_COUNT, e.getMessage());
		}
	}
	
	/**
	 * Bonus Score 1 Border
	 */
	@Test	
	public void validateBonusPowerBorderThrowException(){
		try{
			power.calculateScore(-1, 1);
			Assert.fail("Didn't Threw Exception.");
		}catch(GameScoreException e){
			Assert.assertEquals(GameScoreException.NEGATIVE_COUNT, e.getMessage());
		}
	}

	/**
	 * Bonus Score 2
	 */
	@Test	
	public void validatePowerIncorrectThrowException(){
		try{
			power.calculateScore(1, -10);
			Assert.fail("Didn't Threw Exception.");
		}catch(GameScoreException e){
			Assert.assertEquals(GameScoreException.NEGATIVE_COUNT, e.getMessage());
		}
	}
	
	/**
	 * Bonus Score 2 Border
	 */
	@Test	
	public void validatePowerIncorrectBorderThrowException(){
		try{
			power.calculateScore(1, -1);
			Assert.fail("Didn't Threw Exception.");
		}catch(GameScoreException e){
			Assert.assertEquals(GameScoreException.NEGATIVE_COUNT, e.getMessage());
		}
	}

    /**
	 * Bonus Score 3 
	 */
	@Test	
	public void validatePowerScoreZero(){
		try{
			Assert.assertEquals(0,power.calculateScore(2, 5));
		}catch(GameScoreException e){
			Assert.fail("Threw Exception.");
		}
	}

	/**
	 * Bonus Score 3 Border
	 */
	@Test	
	public void validatePowerBorderScoreZero(){
		try{
			Assert.assertEquals(0,power.calculateScore(1, 1));
		}catch(GameScoreException e){
			Assert.fail("Threw Exception.");
		}
	}

	/**
	 * Bonus Score 4
	 */
    @Test
    public void validatePowerScoreFiveHundred(){
		try{
			Assert.assertEquals(500,power.calculateScore(5, 10));
		}catch(GameScoreException e){
			Assert.fail("Threw Exception.");
		}
	}

	/**
	 * Bonus Score 4 Border
	 */
    @Test
    public void validatePowerScoreFiveHundredBorder(){
		try{
			Assert.assertEquals(500,power.calculateScore(4, 1));
		}catch(GameScoreException e){
			Assert.fail("Threw Exception.");
		}
	}

	/**
	 * Bonus Score 5
	 */
    @Test
    public void validatePowerScore(){
		try{
			Assert.assertEquals(116,power.calculateScore(3, 5));
		}catch(GameScoreException e){
			Assert.fail("Threw Exception.");
		}
	}

	/**
	 * Bonus Score 5 Border
	 */
    @Test
    public void validatePowerScoreBorder(){
		try{
			Assert.assertEquals(5,power.calculateScore(1, 0));
		}catch(GameScoreException e){
			Assert.fail("Threw Exception.");
		}
	}

}
