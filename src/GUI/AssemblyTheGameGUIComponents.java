package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AssemblyTheGameGUIComponents {
	
	private JFrame MainWindow = GUI.MainWindow.window;

	public AssemblyTheGameGUIComponents(){
		new GUI.MainWindow();
		
		AddTheMainWrapperOfTheGameBoard();
		new GenerateGameBoardCells();
		new GUI.StartTheWordsHiddingProcess();
		
		AddRightWrapperInWindow();
		AddShuffleButtonToWrapper();
		AddTheDiscoverWordsCheckbox();
		DisplayTheListOfTheHiddenWords();
		
		MainWindow.pack();
		MainWindow.setVisible(true);
	}
	
	private void AddTheMainWrapperOfTheGameBoard() {
		MainWindow.add(GUIComponents.boardLettersWrapper);
	}
	
	private void AddRightWrapperInWindow() {
		MainWindow.add(GUI.GUIComponents.GetTheRightWrapper());
	}

	private void AddShuffleButtonToWrapper() {
		JPanel shuffleBtn = GUIComponents.GetTheSfuffleButton();
		GUIComponents.boardRightOptionsWrapper.add(shuffleBtn);
	}
	
	private void AddTheDiscoverWordsCheckbox() {
		JPanel panel = GUIComponents.GetCheckboxForDiscoveringTheWordsOnBoard();
		GUIComponents.boardRightOptionsWrapper.add(panel);
	}
	
	private void DisplayTheListOfTheHiddenWords() {
		JPanel allWordsWrapper = GUIComponents.GetWrapperWithAllMissingWordsList();
		GUIComponents.boardRightOptionsWrapper.add(allWordsWrapper);
	}
	
}
