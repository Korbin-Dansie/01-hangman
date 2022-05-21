package hangman;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashSet;
import java.util.Set;

public class Game {
	private final int startLives = 6;

	private int lives;
	// The random word. Hidden from users
	private String word;
	private Set<String> lettersGuessed = new HashSet<String>();

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

	public void addLetterToGuessedLetter(String input) {
		this.lettersGuessed.add(input);

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
