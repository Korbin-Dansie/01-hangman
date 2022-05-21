/**
 * 
 */
package hangman;

/**
 * @author Korbin Dansie
 * 
 */

public class Hangman {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordFileReader wfileReader = new WordFileReader();
		Game game = new Game();
		UserInput userInput = new UserInput();

		boolean playing = true;
		//Start the game
		while(playing == true) {
			// Setup the game
			game.setWord(wfileReader.getRandomWord());
		
			// Check if alive
			while(game.isAlive()) {
				// Display info
				System.out.println("Lives: " + game.getLives());
				System.out.println(game.getReviledWord());
				
				// Get letter
				userInput.requestInput();
				
				// Update guessed letter
				game.addLetterToGuessedLetter(userInput.getInput());
				
				//DEBUG show guessed letters
				System.out.println(game.getLettersGuessed());
			}
			
			
			// Display End game board
			System.out.println("Game Over");
			// Reset the game
			playing = false;
		}
		
	
		userInput.close();
	}

}
