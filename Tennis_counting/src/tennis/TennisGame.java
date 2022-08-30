package tennis;

import java.util.ArrayList;

public interface TennisGame {

	int[] pointWinner(int p);	//승점 얻는 추상메소드

	void dispScoreBoard(ArrayList<String> player);
}
