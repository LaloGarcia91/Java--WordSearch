package Helpers;

import javax.swing.JButton;

public class WordLetterIntersectsWithAnotherWordLetter {
	/*
	 * This class will check if a word letter which is about to fit in the board,
	 * share the the letter that is about to be "replaced" in the cell. Assuming that the cell letter
	 * about to be replaced, belongs to a word already hidden in the board.
	 */
	public static boolean AreTheSame(String newCellLetter, int rowIndexRef, int cellIndexRef) {
		JButton cellAboutToReplace = GUI.RowsAndCells.GetCellFromRow(rowIndexRef, cellIndexRef);
		boolean cellBelongsToWord = Helpers.BoardCellsInfo.CellBelongsAtLeastToOneWord(cellAboutToReplace);
		boolean lettersAreEqual = newCellLetter.equals(cellAboutToReplace.getText());
		if (cellBelongsToWord && !lettersAreEqual) {
			return false;
		}
		return true;
	}
}
