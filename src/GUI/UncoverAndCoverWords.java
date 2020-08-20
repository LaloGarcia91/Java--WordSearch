package GUI;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JButton;

public class UncoverAndCoverWords {

	public static void Uncover(boolean state) {
		Color defaultCellsColor = Helpers.BoardCellsInfo.defaultCellsColor;
		Set<String> allWords = Helpers.BoardCellsInfo.allWordsHiddenInBoard.keySet();
		for (String word : allWords) {
			ArrayList<JButton> wordButtons = Helpers.BoardCellsInfo.allWordsHiddenInBoard.get(word);
			
			Color randomColor = Helpers.RandomColor.Get();
			for (int i = 0; i < wordButtons.size(); i++) {
				JButton wordCell = wordButtons.get(i);
				if(state) {
					wordCell.setBackground(randomColor);
				} else {
					wordCell.setBackground(defaultCellsColor);
				}
			}
		}
		GUI.MissingWordsToFind.HighlightTheWordsAlreadyFound();
	}
}
