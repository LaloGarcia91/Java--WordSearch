package Helpers;

import javax.swing.JButton;

public class WordLetterIntersectsAnotherWord {
	public String cellLetter;
	public int rowIndexRefOfLetter;
	public int cellIndexRefOfLetterInRow;

	public boolean IntersectsAnExistingWordAndIsTheSameLetter() {
		if (!IntersectsAnExistingWord()) {
			return false;
		}
		JButton currentCellOnBoard = GUI.RowsAndCells.GetCellFromRow(rowIndexRefOfLetter, cellIndexRefOfLetterInRow);
		//System.out.println(cellLetter+" --- "+currentCellOnBoard.getText()+" --- "+cellLetter.equals(currentCellOnBoard.getText()));
		return cellLetter.equals(currentCellOnBoard.getText());
	}

	public boolean IntersectsAnExistingWord() {
		JButton currentCellOnBoard = GUI.RowsAndCells.GetCellFromRow(rowIndexRefOfLetter, cellIndexRefOfLetterInRow);
		return Helpers.BoardCellsInfo.CellBelongsAtLeastToOneWord(currentCellOnBoard);
	}
}
