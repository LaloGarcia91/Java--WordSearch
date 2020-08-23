package Events;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

public class ShowOnlyIntersecringWords {
	private JCheckBox checkbox;

	public ShowOnlyIntersecringWords(JCheckBox checkboxClicked) {
		checkbox = checkboxClicked;
		ActivateClick();
	}

	private void ActivateClick() {
		checkbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(checkbox.isSelected()) {
					System.out.println("clickedd !!");
				} else {
					
				}
			}
		});
	}
}
