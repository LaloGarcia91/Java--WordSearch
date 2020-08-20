package Helpers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import javax.swing.JButton;

public class BoardCellsInfo {

	
	public static Hashtable<String, ArrayList<JButton>> allWordsHiddenInBoard = new Hashtable<String, ArrayList<JButton>>();
	public static Color clickedCellDefaultColor = Color.GREEN;
	public static Color defaultCellsColor = GUI.BoardCharacteristics.mainWindowColor;

	public static boolean CellBelongsAtLeastToOneWord(JButton cellBtn) {
		Set<String> allWords = allWordsHiddenInBoard.keySet();
		for (String word : allWords) {
			ArrayList<JButton> wordButtons = allWordsHiddenInBoard.get(word);
			for (int i = 0; i < wordButtons.size(); i++) {
				if (wordButtons.get(i) == cellBtn) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean CellsAreTheSameLetter(JButton cell1, JButton cell2) {
		return cell1.getText().equals(cell2.getText());
	}
	
	public static void StoreWordWithItsCellsInHashMap(String word, JButton newLetterCellToInsert) {
		boolean wordIsAlreadyStored = allWordsHiddenInBoard.containsKey(word);
		if (!wordIsAlreadyStored) {
			allWordsHiddenInBoard.put(word, new ArrayList<JButton>());
		}
		ArrayList<JButton> currentButtonsUsedByWord = allWordsHiddenInBoard.get(word);
		currentButtonsUsedByWord.add(newLetterCellToInsert);
	}
	

}
