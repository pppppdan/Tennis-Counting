package tennis;

import java.util.ArrayList;

public class TennisSetWinner extends TennisRule {

	public void getSetWinner(int set, ArrayList<String> player, boolean tiebreak) {
		while ((setPoint[0] > setPoint[1] ? setPoint[0] : setPoint[1]) != set / 2 + 1) { // 승리 세트 수만큼 반복

			while (!((gamePoint[0] > gamePoint[1] ? gamePoint[0] : gamePoint[1]) >= 6)) { // 6게임 승리 시 1세트 얻음
				pointReset(playerPoint); // 포인트 초기화
				getGameWinner(player);
				// 현재 포인트 존재
			}

			if ((gamePoint[0] > gamePoint[1] ? gamePoint[1] : gamePoint[0]) == 5) { // 게임 듀스 시 재 반복
				while (true) { // 듀스
					pointReset(playerPoint); // 포인트 초기화
					getGameWinner(player);

					if ((gamePoint[0] == gamePoint[1] && gamePoint[0] == 6) && tiebreak) {
						getTieBreakWinner(player, setPoint); // 타이브레이크 적용 시 타이브레이크 승자 구함
						break;
					}
					// 타이브레이크 미적용시 게임 듀스 시작

					if (Math.abs(gamePoint[0] - gamePoint[1]) == 2)
						break;
				}

			}
			if (gamePoint[0] > gamePoint[1])
				setPoint[0]++;

			else
				setPoint[1]++;

			// 현재 게임포인트 존재
			pointReset(gamePoint); // 게임포인트 초기화

		}
		if ((playerPoint[0] > playerPoint[1] ? playerPoint[0] : playerPoint[1]) >= 6)
			dispTieBreakScoreBoard(player);
		else
			dispScoreBoard(player);
		System.out.println("게임 종료");

	}

}
