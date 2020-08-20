package GameStates;

import javax.swing.JPanel;

public class ShuffleBoard {
	private static JPanel board = GUI.GUIComponents.boardLettersWrapper;

	public static void Shuffle() {
		board.removeAll();

		EmptyStaticProperties();
		ResetAndRevalidateGame();
	}

	private static void EmptyStaticProperties() {
		GUI.GUIComponents.allPanelRows.clear();
		Helpers.BoardCellsInfo.allWordsHiddenInBoard.clear();
	}

	private static void ResetAndRevalidateGame() {
		new GUI.GenerateGameBoardCells();
		new GUI.StartTheWordsHiddingProcess();
		GUI.MissingWordsToFind.HighlightTheWordsAlreadyFound();

		if(GUI.GUIComponents.uncoverWordsCheckbox.isSelected()) {
			GUI.UncoverAndCoverWords.Uncover(true);
		}else {
			GUI.UncoverAndCoverWords.Uncover(false);
		}

		board.repaint();
		board.revalidate();
	}

}
