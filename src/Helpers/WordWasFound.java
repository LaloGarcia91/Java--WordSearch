package Helpers;

import java.util.ArrayList;

import javax.swing.JButton;

public class WordWasFound {

	public static boolean Check(String word) {
		ArrayList<JButton> allWordLettersCells = Helpers.BoardCellsInfo.allWordsHiddenInBoard.get(word);
		
		int wordLettersLen = allWordLettersCells.size();
		int wordLettersAlreadyClicked = 0;
		for (JButton letterCell : allWordLettersCells) {
			boolean letterHasBeenClicked = letterCell.getBackground().equals(Helpers.BoardCellsInfo.clickedCellDefaultColor);
			if(letterHasBeenClicked){
				wordLettersAlreadyClicked++;
			}
			if(wordLettersLen == wordLettersAlreadyClicked) {
				// System.out.println("The word: "+word+" has been found.");
				return true;
			}
		}
		return false;
	}
}
