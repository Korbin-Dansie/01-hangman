package hangman;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Game {
	private final int startLives = 6;

	private int lives;
	// The random word. Hidden from users
	private String word;
	private Set<String> lettersGuessed = new HashSet<String>();
	
	//Subset of lettersGuessed
	private Set<String> inCorrectlettersGuessed = new LinkedHashSet<String>();

	public String displayLettersGuseed() {
		String displayString = "";
		
        Iterator<String> it = inCorrectlettersGuessed.iterator();
        while (it.hasNext()) {
            // Print HashSet values
        	displayString += it.next();
        	if(it.hasNext()) {
        		displayString += ", ";
        	}
        }

        return displayString;
	}
	
	/**
	 * Check if they have guessed all the letter in the word
	 * @return
	 */
	public boolean hasWon() {
		CharacterIterator it = new StringCharacterIterator(this.word);
		while (it.current() != CharacterIterator.DONE) {
			if (this.lettersGuessed.contains(String.valueOf(it.current()))) {
				it.next();
				continue;
			}
			// If the set does not contains a letter in the word the user has not guessed it yet
			else {
				return false;
			}
		}
		
		return true;
	}
	
	
	public Set<String> getInCorrectlettersGuessed() {
		return inCorrectlettersGuessed;
	}

	public void setInCorrectlettersGuessed(Set<String> inCorrectlettersGuessed) {
		this.inCorrectlettersGuessed = inCorrectlettersGuessed;
	}

	/**
	 * Return the hidden word formated with correct guesses reviled.
	 * 
	 * @return
	 */
	public String getReviledWord() {
		String hidden = "";

		// Loop though hidden word
		CharacterIterator it = new StringCharacterIterator(this.word);
		while (it.current() != CharacterIterator.DONE) {

//Check if guessed letter is in set.
			if (this.lettersGuessed.contains(String.valueOf(it.current()))) {
				hidden += it.current();
			} else {
				hidden += "_";
			}

			// Moving onto next element in the object
			// using next() method
			it.next();

			// Check letter is not at the end
			if (it.current() != CharacterIterator.DONE) {
				hidden += " ";
			}
		}

		return hidden;
	}

	/**
	 * Checks user input to see what they guessed
	 * If already guessed let them know
	 * If not in word loose a life
	 * @param input
	 */
	public void addLetterToGuessedLetter(String input) {
		
		this.lettersGuessed.add(input);
		if(!word.contains(input)) {
			this.inCorrectlettersGuessed.add(input);
			this.loseLife();
		}

	}
	
	public void displayIncorrectGuesses() {
		System.out.print(this.inCorrectlettersGuessed);
	}

	public Set<String> getLettersGuessed() {
		return lettersGuessed;
	}

	public void setLettersGuessed(Set<String> lettersGuessed) {
		this.lettersGuessed = lettersGuessed;
	}

	public Game() {
		this.lives = startLives;
	}

	public void reset() {
		this.lives = startLives;
		this.word = null;
		this.lettersGuessed.clear();
		this.inCorrectlettersGuessed.clear();

	}

	public boolean isAlive() {
		if (lives > 0) {
			return true;
		}
		return false;
	}

	public void loseLife() {
		this.lives--;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}
