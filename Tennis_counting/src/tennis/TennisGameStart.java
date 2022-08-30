package tennis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TennisGameStart extends TennisGamePrintFormat {

	public ArrayList<String> ruleSelect() throws IOException {

		int set = 3;

		// 시작, 종료 선택
		boolean b = false;
		String input = "";
		do {
			if (b == true)
				System.out.println("\n\t입력오류! 다시 선택해주세요.");
			startScreenPrint();
			input = sc.next();
			if (input.equals("2")) {
				System.out.println();
				System.out.print("\t\t-게임 종료-");
				System.exit(-1);

			}

		} while (b = !(input.matches("[1-2]")));

		// 남자, 여자 선택
		b = false;
		do {
			if (b == true)
				System.out.println("\n\t입력오류! 다시 선택해주세요.");
			matchPlayerGenderSelect();
			input = sc.next();
		} while (b = !(input.matches("[1-2]")));
		boolean gender = true;
		if (input.equals("2"))
			gender = false;

		// 단식, 복식 선택
		b = false;
		do {
			if (b == true)
				System.out.println("\n\t입력오류! 다시 선택해주세요.");
			matchSelect();
			input = sc.next();
		} while (b = !(input.matches("[1-2]")));
		int match = 1; // 단식
		if (input.equals("2"))
			match = 2; // 복식

		// 선수 선택
		FileInOut fio = new FileInOut();
		ArrayList<String> mPlayerList = fio.getMPlayerName();
		ArrayList<String> wPlayerList = fio.getWPlayerName();
		ArrayList<String> teamA = new ArrayList<String>();
		ArrayList<String> teamB = new ArrayList<String>();
		ArrayList<String> player = new ArrayList<>();

		if (match == 1) { // 단식이면

			if (b == true)
				System.out.println("\n\t입력오류! 다시 선택해주세요.");
			if (gender == true) { // 남자 단식
				playerSelect(mPlayerList);
				player = playerList(match, mPlayerList, teamA, teamB);
			} else { // 여자 단식
				playerSelect(wPlayerList);
				player = playerList(match, wPlayerList, teamA, teamB);
			}

			System.out.print("\tTeam A - ");
			playerPrint(teamA);
			System.out.println();
			System.out.print("\tTeam B - ");
			playerPrint(teamB);
			System.out.println();

		} else { // 복식이면

			if (gender == true) { // 남자 복식
				playerSelect(mPlayerList);
				player = playerList(match, mPlayerList, teamA, teamB);
			} else { // 여자 복식
				playerSelect(wPlayerList);
				player = playerList(match, wPlayerList, teamA, teamB);
			}

			System.out.print("\tTeam A - ");
			playerPrint(teamA);
			System.out.println();
			System.out.print("\tTeam B - ");
			playerPrint(teamB);
			System.out.println();
		}

		return player;
	}//

	public int setSelect() {
		Scanner sc = new Scanner(System.in);
		String input;
		boolean b;
		b = false;
		int set = 3;
		do {
			if (b == true)
				System.out.println("\n\t입력오류! 다시 선택해주세요.");
			setMatchSelect();
			input = sc.next();
		} while (b = !(input.matches("[1-2]")));
		set = 5; // 5판 3선
		if (input.equals("2"))
			set = 3; // 3판 2선
		return set;
	}

	public boolean getTieBreak() {// 타이브레이크 선택

		Scanner sc = new Scanner(System.in);
		String input = "";
		boolean tie;

		boolean b = false;
		do {
			if (b == true)
				System.out.println("\n\t입력오류! 다시 선택해주세요.");
			tieBreakSelect();
			input = sc.next();
		} while (b = !(input.matches("[1-2]")));
		tie = true; // 타이브레이크 적용
		if (input.equals("2"))
			tie = false; // 미적용

		return tie;

	}

}// classpackage tennis;
