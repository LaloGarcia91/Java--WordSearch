package GUI;

import java.awt.*;

public class GenerateGameBoardCells {

	public GenerateGameBoardCells() {
		SetGameBoardCharacteristics();
		AddTheRowsAndCellsToBoard();
	}

	private void SetGameBoardCharacteristics() {
		int boardWidthAndHeight = BoardCharacteristics.BoardWidthAndHeight();
		GUIComponents.boardLettersWrapper.setPreferredSize(new Dimension(boardWidthAndHeight, boardWidthAndHeight));
		GUIComponents.boardLettersWrapper.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
	}


	private void AddTheRowsAndCellsToBoard() {
		int cellsPerRow = BoardCharacteristics.CellsPerRow();
		for (int i = 0; i < cellsPerRow; i++) {
			GUIComponents.boardLettersWrapper.add(GUIComponents.GetBoardRow());
		}
	}

}
