package consoleHangman;
//hmf -> hangman functions
public class hmf {
	public static boolean gameRunning = true;
	public static boolean givenUp = false;
	public static String chosenWord = "";
	public static String display = "";
	public static int[] getIndexesOfLetter(char Letter){
		int newSize = 0;
		int[] results = new int[chosenWord.length()];
		for (int i = 0; i < chosenWord.length(); i++){
			if (chosenWord.charAt(i) == Letter){
				results[newSize] = i;
				newSize++;
			}
		}
		int[] realResults = new int[newSize];
		for (int i = 0; i < newSize; i++){
			realResults[i] = results[i];
		}
		return realResults;
	}
	public static String swapLetterAtIndex(String s, int index, String newLetter){
		String newString = "";
		for (int i = 0; i < s.length(); i++){
			if (i != index){
				newString += s.substring(i, i+1);
			} else {
				newString += newLetter;
			}
		}
		return newString;
	}
	public static boolean validateLetter(String l){
		if (l.length() == 1){
			if (chosenWord.contains(l)){
				// letter is found within word
				int[] Indexes = getIndexesOfLetter(l.charAt(0));
				for (int i = 0; i < Indexes.length; i++){
					display = swapLetterAtIndex(display, Indexes[i], chosenWord.substring(Indexes[i], Indexes[i]+1));
				}

				return true;
			}
		} else if (l.equals("!giveup")){
			// in future, quit program
			return false; 
		} else if (l.length() == chosenWord.length()){
			if (l.equals(chosenWord)){
				// they guessed full word
				return true;
			}
		} else {
			// they entered more than one letter & did not guess the right answer.
		}
		return false;
	}
}
