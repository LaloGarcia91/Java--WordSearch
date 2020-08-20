package GUI;

import javax.swing.JFrame;
import java.awt.*;

public class MainWindow {
	
	public static JFrame window = new JFrame();

	public MainWindow() {
		SetMainWindowRules();
	}

	public void SetMainWindowRules() {
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBackground(BoardCharacteristics.mainWindowColor);
		window.setTitle("Word Search - by Lalo Garcia");
		
		Container pane = window.getContentPane();
		GridBagLayout layout = new GridBagLayout();
		pane.setLayout(layout);
		pane.setBackground(BoardCharacteristics.mainWindowColor);

	}
}
