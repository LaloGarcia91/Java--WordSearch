package Helpers;


public class GetRandomInt {

	public static int Get(int min, int max) {
		return (int)(Math.random() * (max - min + 1) + min);
	}
}
