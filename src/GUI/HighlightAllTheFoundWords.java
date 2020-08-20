package GUI;

import java.util.ArrayList;
import java.util.Set;

import javax.swing.JButton;

public class HighlightAllTheFoundWords {

	public static void Highlight() {
		Set<String> allWords = Helpers.BoardCellsInfo.allWordsHiddenInBoard.keySet();
		for (String word : allWords) {
			ArrayList<JButton> wordButtons = Helpers.BoardCellsInfo.allWordsHiddenInBoard.get(word);
			
			int wordLettersLen = wordButtons.size();
			int wordLettersAlreadyClicked = 0;
			for (int i = 0; i < wordLettersLen; i++) {
				JButton letterButton = wordButtons.get(i);
				boolean letterHasBeenClicked = letterButton.getBackground().equals(Helpers.BoardCellsInfo.clickedCellDefaultColor);
				if(letterHasBeenClicked){
					wordLettersAlreadyClicked++;
				}
				if(wordLettersLen == wordLettersAlreadyClicked) {
					//System.out.println("The word: "+word+" has been found.");
				}
			}
		}
		MissingWordsToFind.HighlightTheWordsAlreadyFound();
	}
}
