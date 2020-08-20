package Helpers;
import java.util.Random;

public class RandomLetters {
	private static Random randomNum = new Random();
	private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

	private static String Get() {
		int index = randomNum.nextInt(alphabet.length());
		char letter = alphabet.charAt(index);
		return String.valueOf(letter);
	}
	
	public static String GetLowerCase() {
		return Get().toLowerCase();
	}
	
	public static String GetUpperCase() {
		return Get().toUpperCase();
	}
}
