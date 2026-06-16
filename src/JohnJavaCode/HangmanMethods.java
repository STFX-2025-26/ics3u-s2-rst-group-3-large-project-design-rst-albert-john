package JohnJavaCode;

import java.util.ArrayList;
import java.util.Random;

public class HangmanMethods {
    private String[] wordList = {"abandoned", "abdominal", "eavesdrop", "factoring", "babyproof", "ibuprofen", "Karyotype", "labourers","ultimatum"};
    public String randomWord;
    public ArrayList<Character> guessedLetters = new ArrayList<Character>();
    public int lives = 9;
    public int points = 0;

    public String generateRandomWord() {
    	int randomIndex = (int) (Math.random() * wordList.length);
    	return wordList[randomIndex];
    }

    public boolean checkLetter(String word, char letter) {
    	for (int i = 0; i < word.length(); i++) {
    	    if (word.charAt(i) == letter) {
    	        return true;
    	    }
    	}
    	return false;
    }
}