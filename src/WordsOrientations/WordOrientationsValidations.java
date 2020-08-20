package WordsOrientations;

import java.awt.Component;

public class WordOrientationsValidations {
	/*
	 * This class will check if the cells where a new word is about to fit, actually
	 * EXIST. Meaning, if the cell indexes exist in the board. This needs to be done
	 * because the row and cell index for a word to be hidden, are randomly chosen.
	 * And sometimes, the randomly chosen row and cell index where a word is about
	 * to START fitting, is not always the "optimal" position.
	 * 
	 * Example: Random row index chosen = 1 /// Random cell index chosen = 0 ///
	 * Word to fit = "house" /// Random word orientation chosen =
	 * "VerticallyBottomToTop"
	 * 
	 * In the above example, the word that we are going to fit, exceeds the
	 * characters length in order to fit it in a: "VerticallyBottomToTop"
	 * orientation. Because the first letter to be fitted will be the "H" in the row
	 * index 1, and the cell index 0, the second letter "O" will fit in the row
	 * index 0, cell index 0, AND the letter "S" won't fit anymore, because the row
	 * index -1 doesn't exist.
	 * 
	 * So that's why the program will keep trying different orientations until the
	 * word fits. Although, this class methods only serve to check if the row and
	 * cells indexes where the word is SUPPOSED to fit, exist. If not, the methods
	 * will return false.
	 */

	private Component[] cellsInRow;
	private int cellsCountInRow;
	private int lengthOfWord;

	public String word;
	public int rowIndexToStartFrom;
	public int cellIndexToStartFrom;

	private void Init() {
		cellsInRow = GUI.RowsAndCells.GetCellsInRow(rowIndexToStartFrom);
		cellsCountInRow = cellsInRow.length;
		lengthOfWord = word.length();
	}

	public boolean VerticallyTopToBottom() {
		Init();
		return (rowIndexToStartFrom + (lengthOfWord - 1)) <= (cellsCountInRow - 1);
	}

	public boolean VerticallyBottomToTop() {
		Init();
		return (rowIndexToStartFrom - (lengthOfWord - 1)) >= 0;
	}

	public boolean HorizontallyLeftToRight() {
		Init();
		return (cellIndexToStartFrom + (lengthOfWord - 1)) <= (cellsCountInRow - 1);
	}

	public boolean HorizontallyRightToLeft() {
		Init();
		return (cellIndexToStartFrom - (lengthOfWord - 1)) >= 0;
	}

	public boolean DiagonalTopToBottomRight() {
		Init();
		boolean rowsExist = (rowIndexToStartFrom + (lengthOfWord - 1)) <= (cellsCountInRow - 1);
		boolean cellsExist = (cellIndexToStartFrom + (lengthOfWord - 1)) <= (cellsCountInRow - 1);
		if (rowsExist && cellsExist) {
			return true;
		}
		return false;
	}

	public boolean DiagonalTopToBottomLeft() {
		Init();
		boolean rowsExist = (rowIndexToStartFrom + (lengthOfWord - 1)) <= (cellsCountInRow - 1);
		boolean cellsExist = (cellIndexToStartFrom - (lengthOfWord - 1)) >= 0;
		if (rowsExist && cellsExist) {
			return true;
		}
		return false;
	}

	public boolean DiagonalBottomToTopRight() {
		Init();
		boolean rowsExist = (rowIndexToStartFrom - (lengthOfWord - 1)) >= 0;
		boolean cellsExist = (cellIndexToStartFrom + (lengthOfWord - 1)) <= (cellsCountInRow - 1);
		if (rowsExist && cellsExist) {
			return true;
		}
		return false;
	}

	public boolean DiagonalBottomToTopLeft() {
		Init();
		boolean rowsExist = (rowIndexToStartFrom - (lengthOfWord - 1)) >= 0;
		boolean cellsExist = (cellIndexToStartFrom - (lengthOfWord - 1)) >= 0;
		if (rowsExist && cellsExist) {
			return true;
		}
		return false;
	}

}
