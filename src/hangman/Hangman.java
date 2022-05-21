/**
 * 
 */
package hangman;

import java.util.Scanner;

/**
 * @author Korbin Dansie
 * 
 */

public class Hangman {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String line = "==============================";
		
		Scanner input = new Scanner(System.in); // Create a Scanner object

		WordFileReader wfileReader = new WordFileReader();
		Game game = new Game();
		UserInput userInput = new UserInput(input);

		boolean playing = true;
		// Start the game
		while (playing == true) {
			// Setup the game
			game.setWord(wfileReader.getRandomWord());

			// Check if alive
			while (game.isAlive()) {
				// Display info
				System.out.println("Lives: " + game.getLives());
				if (!game.getInCorrectlettersGuessed().isEmpty()) {
					System.out.println("Guesses: " + game.displayLettersGuseed());
				}
				System.out.println(game.getReviledWord());

				// Get letter
				userInput.requestInput(game);

				// Update guessed letter
				game.addLetterToGuessedLetter(userInput.getInput());

				// Clear the console
				System.out.println(line);

				// Check if they won
				if (game.hasWon()) {
					break;
				}
			}

			// Display End game board
			if (game.hasWon()) {

				System.out.println("__     __          __          __         _ ");
				System.out.println("\\ \\   / /          \\ \\        / /        | |");
				System.out.println(" \\ \\_/ /__  _   _   \\ \\  /\\  / /__  _ __ | |");
				System.out.println("  \\   / _ \\| | | |   \\ \\/  \\/ / _ \\| '_ \\| |");
				System.out.println("   | | (_) | |_| |    \\  /\\  / (_) | | | |_|");
				System.out.println("   |_|\\___/ \\__,_|     \\/  \\/ \\___/|_| |_(_)");
				System.out.println();

			} else {
				System.out.println("   _____                         ____                 _ ");
				System.out.println("  / ____|                       / __ \\               | |");
				System.out.println(" | |  __  __ _ _ __ ___   ___  | |  | |_   _____ _ __| |");
				System.out.println(" | | |_ |/ _` | '_ ` _ \\ / _ \\ | |  | \\ \\ / / _ \\ '__| |");
				System.out.println(" | |__| | (_| | | | | | |  __/ | |__| |\\ V /  __/ |  |_|");
				System.out.println("  \\_____|\\__,_|_| |_| |_|\\___|  \\____/  \\_/ \\___|_|  (_)");
				System.out.println();
			}

			System.out.println("The word was " + game.getWord());

			// Reset the game
			System.out.print("Play again? (y/n): ");
			String again = input.nextLine().toLowerCase();
			if (again.equals("y") || again.equals("yes")) {
				game.reset();
				game.setWord(wfileReader.getRandomWord());
				System.out.println(line);
			} else {
				playing = false;
				System.out.println("Good bye.");
			}
		}

		input.close();
	}

}
