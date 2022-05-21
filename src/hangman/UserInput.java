package hangman;

import java.util.Scanner;
import java.util.Set;

public class UserInput{

	private String input;
    private Scanner in = new Scanner(System.in);  // Create a Scanner object

    /**
     * TODO: Update with the "Class Cleaner"
     */
    public void close() {
    	in.close();
    }
    
	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	/**
	 * Prompt the user for a character Update input variable
	 */
	public void requestInput(Game game) {
		String n = null;
		// Store if input is valid
		boolean isValidInput = false;

		do {
			System.out.print("Enter a letter: ");
			
				n = in.nextLine().toLowerCase();
				isValidInput = validateInput(n, game.getLettersGuessed());

				if (isValidInput) {
					// Update input
					this.input = n;
				}
		} while (!isValidInput);		
	}

	/**
	 * Validate the users input and loops until correct
	 * 
	 * @return 0 = not valid, 1 = valid
	 */
	private boolean validateInput(String in, Set<String> lettersGuessed) {
		// If more than 1 char ask again
		// If not a letter from A-Z
		if (in.matches("[A-Za-z]{1}") && !lettersGuessed.contains(in)) {
			return true;
		}
		
		// Reasons it could be wrong
		System.out.println("Invalid input. Please try again.");
		if(lettersGuessed.contains(in)) {
			System.out.println("Already guessed that letter.");
		}
		
		return false;
	}

}
