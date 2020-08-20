package Events;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.BoardCharacteristics;

public class LettersEvents {
	
	private JButton button;
	
	public LettersEvents(JButton btn) {
		button = btn;
		ActivateClicks();
	}
	
	public void ActivateClicks() {
		Color clickedCellDefaultColor = Helpers.BoardCellsInfo.clickedCellDefaultColor;
		Color defaultCellColor = BoardCharacteristics.mainWindowColor;
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color cellColor = button.getBackground();
				
				if(cellColor.equals(clickedCellDefaultColor)) {
					button.setBackground(defaultCellColor);
				} else {
					button.setBackground(clickedCellDefaultColor);
				}
		
				button.setOpaque(true);
				
				GUI.HighlightAllTheFoundWords.Highlight();
			}
		});
	}
	
}
