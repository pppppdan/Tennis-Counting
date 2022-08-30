package tennis;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class TennisRule implements TennisGame {
	static Scanner sc = new Scanner(System.in);
	int[] playerPoint = { 0, 0 }; // 해당게임 포인트
	int[] gamePoint = { 0, 0 }; // 승리한 게임 수
	int[] setPoint = { 0, 0 }; // 승리한 세트 수
	boolean tieBreak = false;
	int tieBreakBtn = 0;

	public int getP() {
		Random rnd = new Random();
		int p = rnd.nextInt(2); // 0 or 1
		return p;
	}

	@Override
	public int[] pointWinner(int p) {
		if (p == 1) {
			if (playerPoint[0] >= 3) {
				if (playerPoint[0] < playerPoint[1]) {
					playerPoint[1]--;
				} else
					playerPoint[0]++;
			} else
				playerPoint[0]++;
		} else {
			if (playerPoint[1] >= 3) {
				if (playerPoint[0] > playerPoint[1]) {
					playerPoint[0]--;
				} else
					playerPoint[1]++;
			} else
				playerPoint[1]++;
		}
		return playerPoint;
	}
	
	public int[] tieBreakPointWinner(int p) {
	      if (p == 1) {
	          playerPoint[0] += 1;
	       } else
	          playerPoint[1] += 1;
	       return playerPoint;	    

	}

	public void getGameWinner(ArrayList<String> player) {
		do {
			if ("".equals(sc.nextLine())) {
			playerPoint = pointWinner(getP());
			dispScoreBoard(player);
			}
		} while (!((playerPoint[0] > playerPoint[1] ? playerPoint[0] : playerPoint[1]) >= 4));
		
		
		
		if ((playerPoint[0] > playerPoint[1] ? playerPoint[1] : playerPoint[0]) == 3)
			
			while (true) { // 듀스
				if ("".equals(sc.nextLine())) {
				playerPoint = pointWinner(getP());
				dispScoreBoard(player);
				}
				if (Math.abs(playerPoint[0] - playerPoint[1]) == 2) 
					break;
			}

		if (playerPoint[0] > playerPoint[1]) {
			gamePoint[0]++;

		} else {
			gamePoint[1]++;

		}
	}

	public void pointReset(int[] point) { // 포인트, 게임 리셋 메소드
		point[0] = 0;
		point[1] = 0;
	}

	public static void clearScreen() {
		for (int i = 0; i < 40; i++)
			System.out.println("");
	}

	public int[] getTieBreakWinner(ArrayList<String> player, int[] setPoint) {
		pointReset(playerPoint);
		do {
			if ("".equals(sc.nextLine())) {
			playerPoint = tieBreakPointWinner(getP());
			dispTieBreakScoreBoard(player);
			System.out.println("타이브레이크 진행중");
			}
		} while (!((playerPoint[0] > playerPoint[1] ? playerPoint[0] : playerPoint[1]) >= 7));

		if ((playerPoint[0] > playerPoint[1] ? playerPoint[1] : playerPoint[0]) == 6)

			while (true) { // 듀스
				if ("".equals(sc.nextLine())) {
				playerPoint = tieBreakPointWinner(getP());
				dispTieBreakScoreBoard(player);
				}
				if (Math.abs(playerPoint[0] - playerPoint[1]) == 2)
					break;
			}

		if (playerPoint[0] > playerPoint[1]) {
			gamePoint[0]++;

		} else {
			gamePoint[1]++;
		}

		return gamePoint;
	}

	@Override
	public void dispScoreBoard(ArrayList<String> player) {
		String[] scores = { "00\t", "15\t", "30\t", "40\t", "AD\t", "WIN\t" };
		clearScreen();
		System.out.println("=================================================================");
		
			System.out.println("  Team\t\t\tScore\t\tGame\t\tSet");

		if (playerPoint[0] - playerPoint[1] > 1 && playerPoint[0] == 4)
			playerPoint[0] = 5;
		else if (playerPoint[1] - playerPoint[0] > 1 && playerPoint[1] == 4)
			playerPoint[1] = 5;

		// 1team
		if (player.size()==2)
			System.out.printf(" 1team  %s\t\t", player.get(0));
		else
			System.out.printf(" 1team  %s,%s\t", player.get(0), player.get(1));
		System.out.printf("%s\t%d\t\t%d\n", scores[playerPoint[0]], gamePoint[0], setPoint[0]);

		// 2team
		if (player.size()==2)
			System.out.printf(" 2team  %s\t\t", player.get(1));
		else
			System.out.printf(" 2team  %s,%s\t", player.get(2), player.get(3));
		System.out.printf("%s\t%d\t\t%d\n", scores[playerPoint[1]], gamePoint[1], setPoint[1]);

		System.out.println("=================================================================");

	}

	public void dispTieBreakScoreBoard(ArrayList<String> player) {
		
		clearScreen();
		System.out.println("=================================================================");

		System.out.println("  Team\t\t\tScore\t\tGame\t\tSet");

		// 1team
		if (player.size()==2)
			System.out.printf(" 1team  %s\t\t", player.get(0));
		else
			System.out.printf(" 1team  %s,%s\t", player.get(0), player.get(1));
		System.out.printf("%d\t\t%d\t\t%d\n", playerPoint[0], gamePoint[0], setPoint[0]);

		// 2team
		if (player.size()==2)
			System.out.printf(" 2team  %s\t\t", player.get(1));
		else
			System.out.printf(" 2team  %s,%s\t", player.get(2), player.get(3));
		System.out.printf("%d\t\t%d\t\t%d\n", playerPoint[1], gamePoint[1], setPoint[1]);

		System.out.println("=================================================================");

	}

}