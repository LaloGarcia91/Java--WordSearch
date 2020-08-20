package GUI;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RowsAndCells {

	private static ArrayList<JPanel> allRows = GUI.GUIComponents.allPanelRows;

	
	public static int GetRandomRowIndex() {
		return Helpers.GetRandomInt.Get(0, allRows.size()-1);
	}

	public static int GetRandomCellIndexFromRow(int rowIndex) {
		Component[] rowComponents = GetCellsInRow(rowIndex);
		return Helpers.GetRandomInt.Get(0, rowComponents.length-1);
	}
	
	public static Component[] GetCellsInRow(int rowIndex) {
		return allRows.get(rowIndex).getComponents();
	}

	public static void RevalidateRow(JPanel row) {
		row.revalidate();
	}

	public static JButton GetNewCell(String letter) {
		return GUIComponents.GetButton(letter);
	}
	
	public static JButton GetCellFromRow(int rowIndex, int cellIndex) {
		return (JButton)GetCellsInRow(rowIndex)[cellIndex];
	}
}
