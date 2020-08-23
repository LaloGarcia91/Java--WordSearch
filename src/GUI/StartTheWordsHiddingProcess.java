package GUI;

import java.util.ArrayList;

public class StartTheWordsHiddingProcess {

	private WordsOrientations.FitDiagonal FitDiagonal = new WordsOrientations.FitDiagonal();
	private WordsOrientations.FitVertically FitVertically = new WordsOrientations.FitVertically();
	private WordsOrientations.FitHorizontally FitHorizontally = new WordsOrientations.FitHorizontally();
	private Helpers.WordsToHide WordsToHide = new Helpers.WordsToHide();

	private final int maxAttemptsAllowedToFitWord = 1000;
	private int attemptsForFittingWord = 0;

	private int rowIndexToStartFittingWord;
	private int cellIndexToStartFrom;
	private String currentWordFitting;

	public StartTheWordsHiddingProcess() {
		SetRandomRowAndCellIndexToStartFrom();
		StartHiddingAllWords();
	}

	private void SetRandomRowAndCellIndexToStartFrom() {
		rowIndexToStartFittingWord = RowsAndCells.GetRandomRowIndex();
		cellIndexToStartFrom = RowsAndCells.GetRandomCellIndexFromRow(rowIndexToStartFittingWord);
	}

	private void StartHiddingAllWords() {
		ArrayList<String> words = WordsToHide.words;
		for (int i = 0; i < words.size(); i++) {
			String word = words.get(i);
			currentWordFitting = word;
			StartAttemptsToFitWord();
		}
	}

	private void StartAttemptsToFitWord() {
		while (true) {
			if (attemptsForFittingWord >= maxAttemptsAllowedToFitWord) {
				StringBuilder tooManyAttempsMsg = new StringBuilder();
				tooManyAttempsMsg.append(attemptsForFittingWord + " attemps where done to fit the word: " + currentWordFitting
						+ "... Which means there's no more free space in the board to fit this word.");
				System.out.println(tooManyAttempsMsg);
				attemptsForFittingWord = 0;
				return;
			}
			
			boolean validOrientationPicked = FitWordInRandomOrientation();
			if (validOrientationPicked) {
				attemptsForFittingWord = 0;
				return;
			} else {
				SetRandomRowAndCellIndexToStartFrom();
			}
		}
	}

	private boolean FitWordInRandomOrientation() {
		attemptsForFittingWord++;
		int randomNumber = Helpers.GetRandomInt.Get(1, 3);
		switch (randomNumber) {
		case 1:
			return FitVertically();
		case 2:
			return FitHorizontally();
		case 3:
			return FitDiagonally();
		}
		return false;
	}

	private boolean FitVertically() {
		FitVertically.word = currentWordFitting;
		FitVertically.rowIndexToStartFrom = rowIndexToStartFittingWord;
		FitVertically.cellIndexToStartFrom = cellIndexToStartFrom;
		return FitVertically.Init();
	}

	private boolean FitHorizontally() {
		FitHorizontally.word = currentWordFitting;
		FitHorizontally.rowIndexToStartFrom = rowIndexToStartFittingWord;
		FitHorizontally.cellIndexToStartFrom = cellIndexToStartFrom;
		return FitHorizontally.Init();
	}

	private boolean FitDiagonally() {
		FitDiagonal.word = currentWordFitting;
		FitDiagonal.rowIndexToStartFrom = rowIndexToStartFittingWord;
		FitDiagonal.cellIndexToStartFrom = cellIndexToStartFrom;
		return FitDiagonal.Init();
	}

}
