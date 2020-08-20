package GUI;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class GUIComponents {

	public static Helpers.WordsToHide WordsToHide = new Helpers.WordsToHide();
	public static JPanel boardRightOptionsWrapper = new JPanel();
	public static JPanel boardLettersWrapper = new JPanel();
	public static JPanel wordsToFindWrapper = new JPanel();
	public static JCheckBox uncoverWordsCheckbox = new JCheckBox();

	public static ArrayList<JPanel> allPanelRows = new ArrayList<JPanel>();
	public static final int cellsWidth = 50;

	public static JButton GetButton(String randomLetter) {
		JButton button = new JButton(randomLetter);
		button.setPreferredSize(new Dimension(cellsWidth, cellsWidth));
		button.setBorder(null);
		button.setForeground(Color.GRAY);
		button.setBackground(BoardCharacteristics.mainWindowColor);
		button.setOpaque(true);

		new Events.LettersEvents(button);
		return button;
	}

	public static JPanel GetBoardRow() {
		GridBagLayout layout = new GridBagLayout();
		JPanel panelRow = new JPanel();
		panelRow.setLayout(layout);
		panelRow.setBackground(new Color(0, 0, 0, 0));

		int cellsNumber = BoardCharacteristics.CellsPerRow();
		for (int i = 0; i < cellsNumber; i++) {
			String randomLetter = Helpers.RandomLetters.GetUpperCase();
			JButton button = GetButton(randomLetter);
			panelRow.add(button);
		}

		allPanelRows.add(panelRow);
		return panelRow;
	}

	public static JPanel GetTheSfuffleButton() {
		Color backgroundColor = new Color(40, 85, 138, 255);

		JPanel wrapper = new JPanel();
		JButton button = new JButton();
		button.setText("Re-Shuffle");
		button.setPreferredSize(new Dimension(300, 50));
		button.setBorder(null);
		button.setForeground(Color.WHITE);
		button.setBackground(backgroundColor);
		button.setOpaque(true);

		new Events.ReGenerateBoardButton(button);
		
		wrapper.add(button);
		wrapper.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		wrapper.setMaximumSize(wrapper.getPreferredSize());
		return wrapper;
	}
	
	public static JPanel GetTheRightWrapper() {
		int width = 200;
		int height = MainWindow.window.getPreferredSize().height;

		boardRightOptionsWrapper.setBorder(new MatteBorder(0, 3, 0, 0, Color.GRAY));
		boardRightOptionsWrapper.setPreferredSize(new Dimension(width, height));
		boardRightOptionsWrapper.setLayout(new BoxLayout(boardRightOptionsWrapper, BoxLayout.Y_AXIS));
		boardRightOptionsWrapper.setOpaque(true);
		return boardRightOptionsWrapper;
	}
	
	public static JPanel GetWrapperWithAllMissingWordsList() {
		wordsToFindWrapper.setLayout(new BoxLayout(GUIComponents.wordsToFindWrapper, BoxLayout.Y_AXIS));
		
		for (int i = 0; i < GUIComponents.WordsToHide.words.size(); i++) {
			String word = GUIComponents.WordsToHide.words.get(i);
			JLabel label = new JLabel(word);
			label.setForeground(Color.RED);
			label.setFont(new Font(null, Font.BOLD, 18));
			
			JPanel panel = new JPanel();
			panel.setOpaque(false);
			panel.add(label);
			GUIComponents.wordsToFindWrapper.add(panel);
			MissingWordsToFind.words.add(label);
		}
		wordsToFindWrapper.setMaximumSize(wordsToFindWrapper.getPreferredSize());
		return wordsToFindWrapper;
	}
	
	public static JPanel GetCheckboxForDiscoveringTheWordsOnBoard() {
		JPanel wrapper = new JPanel();
		uncoverWordsCheckbox.setText("Discover words");
        wrapper.add(uncoverWordsCheckbox);
    	wrapper.setMaximumSize(wrapper.getPreferredSize());
    	new Events.DiscoverWordsBtn(uncoverWordsCheckbox);
		return wrapper;
	}

}
