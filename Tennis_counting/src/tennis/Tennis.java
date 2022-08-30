package tennis;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Tennis {

	public static void main(String[] args) throws IOException, ClassNotFoundException, URISyntaxException {
		// 메인클래스
		
		TennisGameStart gs = new TennisGameStart();
		TennisSetWinner sw = new TennisSetWinner();
		ArrayList<String> player = gs.ruleSelect();
		int set = gs.setSelect();
		boolean tiebreak = gs.getTieBreak();	
		sw.getSetWinner(set, player, tiebreak);
				
		try {
			System.out.println("10초 후 프로그램 종료");
			Thread.sleep(10000); //5초 대기			
		   } catch (InterruptedException e) {

			e.printStackTrace();

		  }

	}

}
