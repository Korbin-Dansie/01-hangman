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
				System.out.println("\n\n\n\n\n\n");

				
				System.out.println("Lives: " + game.getLives());
				if(!game.getInCorrectlettersGuessed().isEmpty()) {
					System.out.println("Guesses" + game.getInCorrectlettersGuessed());
				}
				System.out.println(game.getReviledWord());
				
				// Get letter
				// make them guess again if they already guessed the letter
				do {
				userInput.requestInput();
				if(game.getLettersGuessed().contains(userInput.getInput())) {
					System.out.println("Already guessed that letter.");
				}
				} while(game.getLettersGuessed().contains(userInput.getInput()));
				
				// Update guessed letter
				game.addLetterToGuessedLetter(userInput.getInput());
				
				//Check if they won
				if(game.hasWon()) {
					break;
				}
			}
			
			
			// Display End game board
			if(game.hasWon()) {
				System.out.println("You won.");
			} else {
				System.out.println("Game Over.");
			}
			
			System.out.println("The word was " + game.getWord());

			// Reset the game
			playing = false;
		}
		
	
		userInput.close();
	}

}
