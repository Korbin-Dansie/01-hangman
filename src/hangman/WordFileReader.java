package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class WordFileReader {
	private static String location = "src/hangman/";
	private static String textLocation = "words.txt";
	private static File fileLocation = new File(location + textLocation);
	private int count;

	public WordFileReader() {
		this.count = this.countLines();
	}

	/**
	 * Returns a random words for the list for the users to guess
	 * @return
	 */
	public String getRandomWord() {
		try {
			Scanner sc = new Scanner(fileLocation);
			int randomNum = ThreadLocalRandom.current().nextInt(0, this.count);
			int count = 0;

			String word;

			// Increment till we get to a random word
			while (count != randomNum) {
				count++;
				sc.nextLine();
			}

			word = sc.nextLine();
			sc.close();
			return word;
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred. Could not count the number of lines");
			e.printStackTrace();
		}

		//Could not read the file
		return null;
	}

	/**
	 * Counts all the lines in a files starting at 0
	 * @return the total number of lines
	 */
	private int countLines() {
		int count = 0;

		try {
			// Gets the actual word we want
			Scanner sc = new Scanner(fileLocation);

			// Test

			while (sc.hasNextLine()) {
				count++;
				sc.nextLine();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred. Could not count the number of lines");
			e.printStackTrace();
		}
		return count;
	}


	/**
	 * Function for debugging
	 * Prints all the words in the console.
	 */
	public void printWordList() {
		try {
			// Gets the actual word we want
			Scanner myReader = new Scanner(fileLocation);


			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
}
