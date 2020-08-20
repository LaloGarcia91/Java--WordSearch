package Helpers;

import java.awt.Color;
import java.util.ArrayList;

public class RandomColor {

	public static Color Get(){
		ArrayList<Color> colors = new ArrayList<Color>();
		colors.add(Color.BLUE);
		colors.add(Color.YELLOW);
		colors.add(Color.MAGENTA);
		colors.add(Color.CYAN);
		colors.add(Color.PINK);
		colors.add(Color.RED);
		colors.add(Color.ORANGE);
		
		int randomIndex = GetRandomInt.Get(0, colors.size()-1);
		return colors.get(randomIndex);
	}
	
}
	
