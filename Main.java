package consoleHangman;
import java.util.Scanner;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.File;

public class Main {
	public static void main(String[] args) {
		String[] wordList = null;
		int wordCount = 0;
		try {
			File f = new File(System.getProperty("user.dir") + "\\wordlist.txt");
			Scanner scan = new Scanner(f);
			while (scan.hasNextLine()) {
				wordCount++;
				String[] newWordList = new String[wordCount];
				newWordList[wordCount-1] = scan.nextLine();
				if (wordList != null && wordCount > 0) {
					for (int i = 0; i < wordList.length; i++) {
						newWordList[i] = wordList[i];
					}
				}
				wordList = newWordList;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (hmf.gameRunning == true){
			Random Rand = new Random();
			hmf.display = "";
			hmf.chosenWord = wordList[Rand.nextInt(wordList.length)];
			for (int i = 0; i < hmf.chosenWord.length(); i++){
				hmf.display += '_';
			}
			System.out.println(hmf.display);
			//display = swapLetterAtIndex(display, 0, chosenWord.substring(0, 1));
			System.out.println(hmf.display);
			Scanner console = new Scanner(System.in);
			String guess = "";
			while (!guess.equals(hmf.chosenWord) && !hmf.display.equals(hmf.chosenWord) && hmf.givenUp == false){
				System.out.println("Enter a letter guess: ");
				guess = console.nextLine();
				if (hmf.validateLetter(guess)){
					System.out.println("Good guess!");
				} else if (guess.equals("!giveup")) {
					hmf.givenUp = true;
					break;
				} else {
					System.out.println("No, bad guess!");
				}
				System.out.println(hmf.display);
			}
			if (hmf.givenUp == false) {
				System.out.println("You win! You guessed the word " + hmf.chosenWord);
				System.out.println("Type yes to play again: ");
				String answer = console.nextLine();
				if (!answer.equals("yes")){
					hmf.gameRunning = false;
				}
			} else {
				System.out.println("You gave up! The word was " + hmf.chosenWord);
				System.out.println("Type yes to play again: ");
				String answer = console.nextLine();
				if (!answer.equals("yes")){
					hmf.gameRunning = false;
					console.close();
				} else {
					hmf.givenUp = false;
				}
			}
		}
	}
}
