package Events;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

public class DiscoverWordsBtn {

	private JCheckBox checkbox;

	public DiscoverWordsBtn(JCheckBox checkboxClicked) {
		checkbox = checkboxClicked;
		ActivateClick();
	}

	private void ActivateClick() {
		checkbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(checkbox.isSelected()) {
					GUI.UncoverAndCoverWords.Uncover(true);
				} else {
					GUI.UncoverAndCoverWords.Uncover(false);
				}
			}
		});
	}

}
