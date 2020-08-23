package Helpers;

import java.util.Set;

public class AtLeastOneWordIsHIdden {

	public static boolean Check() {
		Set<String> allWords = BoardCellsInfo.allWordsHiddenInBoard.keySet();
		System.out.println(allWords);
		for (String word : allWords) {
			boolean wordHasCells = BoardCellsInfo.allWordsHiddenInBoard.get(word).size() > 0;
			if(wordHasCells) {
				return true;
			}
		}
		return false;
	}
}
