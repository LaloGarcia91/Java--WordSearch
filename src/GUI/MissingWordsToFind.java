package GUI;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;

public class MissingWordsToFind {

	public static ArrayList<JLabel> words = new ArrayList<JLabel>();
	
	public static void HighlightTheWordsAlreadyFound() {
		for(int i=0; i<words.size(); i++) {
			JLabel wordLabel = words.get(i);
			String word = wordLabel.getText();
			boolean wordWasFound = Helpers.WordWasFound.Check(word);
			
			if(wordWasFound) {
				wordLabel.setForeground(Helpers.BoardCellsInfo.clickedCellDefaultColor);
			} else {
				wordLabel.setForeground(Color.RED);
			}
		}
	}
	
}
