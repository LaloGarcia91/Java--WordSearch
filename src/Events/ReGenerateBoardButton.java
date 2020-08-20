package Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ReGenerateBoardButton {

	public JButton button;
	
	public ReGenerateBoardButton(JButton btn) {
		button = btn;
		ActivateClicks();
	}
	
	public void ActivateClicks() {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameStates.ShuffleBoard.Shuffle();
			}
		});
	}
	
	
}
