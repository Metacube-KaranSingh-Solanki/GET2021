
public class StringOperations {
	
	/**
	 * Compares two strings
	 * @param str1 represents first string, requires not null
	 * @param str2 represents second string, requires not null
	 * @return this method returns 1 if both are equal, 0 if they're not equal
	 */
	public int compare(String str1, String str2) {
		if (str1.length() != str2.length()) 
			return 0;
		else {
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) != str2.charAt(i))
					return 0;
			}
		}
		return 1;									
	}
	
	/**
	 * Reverses a string
	 * @param str represents a string, requires not null
	 * @return reverse of the string
	 */
	public String reverse(String str) {
		StringBuilder reverseStr = new StringBuilder();
		for (int i = str.length()-1; i >= 0; i--) {
			reverseStr.append(str.charAt(i));
		}
		return reverseStr.toString();
	}
	
	/**
	 * Alters the case of a string, replace uppercase letter to lowercase letter and vice-versa
	 * @param str string to which alteration to be done, requires not null
	 * @return string with altered cases
	 */
	public String alterCase(String str) {
		int asciiDifference = 32;					// Difference between ASCII of 'A' and 'a', used in conversion
		StringBuilder alterString = new StringBuilder("");
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 'A' && ch <= 'Z')	
				ch = (char)(ch + asciiDifference);
			else if (ch >= 'a' && ch <= 'z')
				ch = (char)(ch - asciiDifference);
				
			alterString.append(ch);
		}
		return alterString.toString();
	}
	
	/**
	 * Finds the largest word in a string.
	 * @param str string from largest word to be found, requires not null
	 * @return largest word, if more than one words are of same length returns the last largest word
	 */
	public String findLargestWord(String str) {
		StringBuilder largestWord = new StringBuilder("");
		StringBuilder word = new StringBuilder("");
		str += ' ';									// require a space at the end to detect the last word
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch != ' ')
				word.append(ch);
			else {
				if (word.length() >= largestWord.length()) {
					largestWord.setLength(0);
					largestWord.append(word);
				}
				word.setLength(0);
			}
		}
		return largestWord.toString();
	}
}
