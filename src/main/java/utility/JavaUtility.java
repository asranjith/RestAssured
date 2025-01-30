package utility;

import java.util.Random;

public class JavaUtility {
	
	/**
	 * @author Ranjith AS
	 * @return number 
	 * Method to generate a random number
	 */
	public int randomNumber() {
		Random ran = new Random();
		return ran.nextInt(500);
	}
	
	/**
	 * Generates a unique email address by appending a random number to the username.
	 *
	 * @author Ranjith AS
	 * @param word The original email address in the format "username@gmail.com".
	 * @return A unique email address with a random number appended to the username.
	 */
	public String uniqueEmail(String word) {
		int ran = randomNumber();
		 String[] words = word.split("@");
		 return words[0]+ran+"@"+words[1];
	}
}
