package GUI;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ReplaceCellWithNewCell {
	public String wordWhichTheNewCellBelongs;
	public int rowIndex;
	public int cellIndex;
	public JButton newLetterCell;

	public void Replace() {
		JPanel rowAboutToAffect = GUI.GUIComponents.allPanelRows.get(rowIndex);
		JButton oldCellAboutToReplace = GUI.RowsAndCells.GetCellFromRow(rowIndex, cellIndex);
		boolean oldCellAndNewCellHaveTheSameLetter = Helpers.BoardCellsInfo.CellsAreTheSameLetter(oldCellAboutToReplace,
				newLetterCell);
		boolean cellBelongsToAWord = Helpers.BoardCellsInfo.CellBelongsAtLeastToOneWord(oldCellAboutToReplace);

		if (cellBelongsToAWord && oldCellAndNewCellHaveTheSameLetter) {
			Helpers.BoardCellsInfo.StoreWordWithItsCellsInHashMap(wordWhichTheNewCellBelongs, oldCellAboutToReplace);
		} else {
			rowAboutToAffect.remove(cellIndex);
			rowAboutToAffect.add(newLetterCell, cellIndex);
			GUI.RowsAndCells.RevalidateRow(rowAboutToAffect);
			Helpers.BoardCellsInfo.StoreWordWithItsCellsInHashMap(wordWhichTheNewCellBelongs, newLetterCell);
		}
	}

}
