package GUI;

import java.awt.Color;
import java.util.ArrayList;

public class BoardCharacteristics {
	public static final Color mainWindowColor = new Color(50, 50, 50, 255);
	
	public static int CellsPerRow() {
		Helpers.WordsToHide WordsToHide = new Helpers.WordsToHide();
		ArrayList<String> words = WordsToHide.words;
		int longestWordLen = 0;
		for(int i=0; i<words.size(); i++) {
			int wordLen = words.get(i).length();
			if(wordLen > longestWordLen) {
				longestWordLen = wordLen;
			}
		}
		return longestWordLen * 2;
	}
	
	public static int BoardWidthAndHeight() {
		return ((CellsPerRow() * GUIComponents.cellsWidth));
	}
}
