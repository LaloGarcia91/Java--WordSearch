package WordsOrientations;

import javax.swing.JButton;

import GUI.GUIComponents;

public class FitDiagonal {
	private GUI.ReplaceCellWithNewCell ReplaceCellWithNewCell = new GUI.ReplaceCellWithNewCell();
	private Helpers.WordLetterIntersectsAnotherWord WordsIntersections = new Helpers.WordLetterIntersectsAnotherWord();
	private boolean wordFits_topToBottomRight;
	private boolean wordFits_topToBottomLeft;
	private boolean wordFits_bottomToTopRight;
	private boolean wordFits_bottomToTopLeft;
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

		wordFits_topToBottomRight = wordFitValidations.DiagonalTopToBottomRight();
		wordFits_topToBottomLeft = wordFitValidations.DiagonalTopToBottomLeft();
		wordFits_bottomToTopRight = wordFitValidations.DiagonalBottomToTopRight();
		wordFits_bottomToTopLeft = wordFitValidations.DiagonalBottomToTopLeft();

		fitsAllOrientations = wordFits_topToBottomRight && wordFits_topToBottomLeft && wordFits_bottomToTopRight
				&& wordFits_bottomToTopLeft;

		return Fit();
	}

	private boolean Fit() {
		boolean fitsInValidCells = WordWillFitInAValidPlace();
		if (GUIComponents.showOnlyIntersectingWordsCheckbox.isSelected()) {
			boolean atLeastOneWordIsHidden = Helpers.AtLeastOneWordIsHIdden.Check();
			if(atLeastOneWordIsHidden) {
				fitsInValidCells = WordValidIntersectWithAtLeastAnotherWord();	
			}
		}

		if (!fitsInValidCells) {
			return false;
		}

		for (int i = 0; i < word.length(); i++) {
			String letterAboutToFit = String.valueOf(word.charAt(i)).toUpperCase();
			newLetterCellToInsert = GUI.RowsAndCells.GetNewCell(letterAboutToFit);

			if (wordFits_topToBottomRight || fitsAllOrientations) {
				cellIndexAboutToAffect = cellIndexToStartFrom + i;
				rowIndexAboutToAffect = rowIndexToStartFrom + i;
			} else if (wordFits_topToBottomLeft) {
				cellIndexAboutToAffect = cellIndexToStartFrom - i;
				rowIndexAboutToAffect = rowIndexToStartFrom + i;
			} else if (wordFits_bottomToTopRight) {
				cellIndexAboutToAffect = cellIndexToStartFrom + i;
				rowIndexAboutToAffect = rowIndexToStartFrom - i;
			} else if (wordFits_bottomToTopLeft) {
				cellIndexAboutToAffect = cellIndexToStartFrom - i;
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

			if (wordFits_topToBottomRight || fitsAllOrientations) {
				rowIndexToAffect = rowIndexToStartFrom + i;
				cellIndexToAffect = cellIndexToStartFrom + i;
			} else if (wordFits_topToBottomLeft) {
				rowIndexToAffect = rowIndexToStartFrom + i;
				cellIndexToAffect = cellIndexToStartFrom - i;
			} else if (wordFits_bottomToTopRight) {
				rowIndexToAffect = rowIndexToStartFrom - i;
				cellIndexToAffect = cellIndexToStartFrom + i;
			} else if (wordFits_bottomToTopLeft) {
				rowIndexToAffect = rowIndexToStartFrom - i;
				cellIndexToAffect = cellIndexToStartFrom - i;
			}

			WordsIntersections.cellLetter = letterAboutToFit;
			WordsIntersections.rowIndexRefOfLetter = rowIndexToAffect;
			WordsIntersections.cellIndexRefOfLetterInRow = cellIndexToAffect;
			boolean newLetterIntersectsAnotherWordLetter = WordsIntersections.IntersectsAnExistingWord();
			boolean newLetterIntersectsAndAreTheSameLetter = WordsIntersections
					.IntersectsAnExistingWordAndIsTheSameLetter();

			if (newLetterIntersectsAnotherWordLetter) {
				if (!newLetterIntersectsAndAreTheSameLetter) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean WordValidIntersectWithAtLeastAnotherWord() {
		int rowIndexToAffect = 0;
		int cellIndexToAffect = 0;
		int correctIntersections = 0;
		int wrongIntersections = 0;
		for (int i = 0; i < word.length(); i++) {
			String letterAboutToFit = String.valueOf(word.charAt(i)).toUpperCase();

			if (wordFits_topToBottomRight || fitsAllOrientations) {
				rowIndexToAffect = rowIndexToStartFrom + i;
				cellIndexToAffect = cellIndexToStartFrom + i;
			} else if (wordFits_topToBottomLeft) {
				rowIndexToAffect = rowIndexToStartFrom + i;
				cellIndexToAffect = cellIndexToStartFrom - i;
			} else if (wordFits_bottomToTopRight) {
				rowIndexToAffect = rowIndexToStartFrom - i;
				cellIndexToAffect = cellIndexToStartFrom + i;
			} else if (wordFits_bottomToTopLeft) {
				rowIndexToAffect = rowIndexToStartFrom - i;
				cellIndexToAffect = cellIndexToStartFrom - i;
			}

			WordsIntersections.cellLetter = letterAboutToFit;
			WordsIntersections.rowIndexRefOfLetter = rowIndexToAffect;
			WordsIntersections.cellIndexRefOfLetterInRow = cellIndexToAffect;
			boolean newLetterIntersectsAnotherWordLetter = WordsIntersections.IntersectsAnExistingWord();
			boolean newLetterIntersectsAndAreTheSameLetter = WordsIntersections
					.IntersectsAnExistingWordAndIsTheSameLetter();

			if (newLetterIntersectsAnotherWordLetter) {
				if (newLetterIntersectsAndAreTheSameLetter) {
					correctIntersections++;
				} else {
					wrongIntersections++;
				}
			}
		}
		if (wrongIntersections > 0) {
			return false;
		}
		if (correctIntersections > 0) {
			return true;
		}
		return false;
	}

	private void ReplaceBoardCellWithNewOne() {
		ReplaceCellWithNewCell.wordWhichTheNewCellBelongs = word;
		ReplaceCellWithNewCell.rowIndex = rowIndexAboutToAffect;
		ReplaceCellWithNewCell.cellIndex = cellIndexAboutToAffect;
		ReplaceCellWithNewCell.newLetterCell = newLetterCellToInsert;
		ReplaceCellWithNewCell.Replace();
	}
}
