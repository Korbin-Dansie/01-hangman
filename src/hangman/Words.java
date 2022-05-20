package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Words {
	public static void main(String[] args) {
		String textLocation = "Hellow";

		try {
			File myObj = new File(textLocation);
			Scanner myReader = new Scanner(myObj);
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
