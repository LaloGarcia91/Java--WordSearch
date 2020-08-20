package WordsOrientations;

import javax.swing.JButton;

public class FitVertically {
	private GUI.ReplaceCellWithNewCell ReplaceCellWithNewCell = new GUI.ReplaceCellWithNewCell();
	private boolean wordFits_topToBottom;
	private boolean wordFits_BottomToTop;
	private boolean fitsAllOrientations;
	private int cellIndexAboutToAffect;
	private int rowIndexAboutToAffect;
	private JButton newLetterCellToInsert;

	public String word;
	public int rowIndexToStartFrom;
	public int cellIndexToStartFrom;

	public boolean Init() {
		WordsOrientations.WordOrientationsValidations wordFitValidations = new WordsOrientations.WordOrientationsValidations();
		wordFitValidations.word = word;
		wordFitValidations.rowIndexToStartFrom = rowIndexToStartFrom;
		wordFitValidations.cellIndexToStartFrom = cellIndexToStartFrom;

		wordFits_topToBottom = wordFitValidations.VerticallyTopToBottom();
		wordFits_BottomToTop = wordFitValidations.VerticallyBottomToTop();
		fitsAllOrientations = wordFits_topToBottom && wordFits_BottomToTop;

		return Fit();
	}

	private boolean Fit() {
		if (!WordWillFitInAValidPlace()) {
			return false;
		}

		for (int i = 0; i < word.length(); i++) {
			String letterAboutToFit = String.valueOf(word.charAt(i)).toUpperCase();
			newLetterCellToInsert = GUI.RowsAndCells.GetNewCell(letterAboutToFit);

			if (wordFits_topToBottom || fitsAllOrientations) {
				cellIndexAboutToAffect = cellIndexToStartFrom;
				rowIndexAboutToAffect = rowIndexToStartFrom + i;
			} else if (wordFits_BottomToTop) {
				cellIndexAboutToAffect = cellIndexToStartFrom;
				rowIndexAboutToAffect = rowIndexToStartFrom - i;
			}
			ReplaceBoardCellWithNewOne();
		}
		return true;
	}

	private boolean WordWillFitInAValidPlace() {
		int rowIndexToAffect = 0;
		int cellIndexToAffect = 0;
		for (int i = 0; i < word.length(); i++) {
			String letterAboutToFit = String.valueOf(word.charAt(i)).toUpperCase();

			if (wordFits_topToBottom || fitsAllOrientations) {
				rowIndexToAffect = rowIndexToStartFrom + i;
				cellIndexToAffect = cellIndexToStartFrom;
			} else if (wordFits_BottomToTop) {
				rowIndexToAffect = rowIndexToStartFrom - i;
				cellIndexToAffect = cellIndexToStartFrom;
			}

			boolean validate = Helpers.WordsShareTheSameLetter.Check(letterAboutToFit, rowIndexToAffect,
					cellIndexToAffect);
			if (!validate) {
				return false;
			}
		}
		return true;
	}

	private void ReplaceBoardCellWithNewOne() {
		ReplaceCellWithNewCell.wordWhichTheNewCellBelongs = word;
		ReplaceCellWithNewCell.rowIndex = rowIndexAboutToAffect;
		ReplaceCellWithNewCell.cellIndex = cellIndexAboutToAffect;
		ReplaceCellWithNewCell.newLetterCell = newLetterCellToInsert;
		ReplaceCellWithNewCell.Replace();
	}
}
