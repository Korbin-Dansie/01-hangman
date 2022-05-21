package hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInput {

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
	public void requestInput() {
		String n = null;
		// Store if input is valid
		boolean isValidInput = false;

		do {
			System.out.println("Enter a letter: ");
			
				n = in.nextLine();
				isValidInput = validateInput(n);

				if (!isValidInput) {
					System.out.println("Invalid input. Please try again.");
				}
				// once finished
				else {
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
	private boolean validateInput(String in) {
		// If more than 1 char ask again
		// If not a letter from A-Z
		if (in == null) {
			return false;
		}
		if (in.matches("[A-Za-z]{1}")) {
			return true;
		}
		return false;
	}

}
