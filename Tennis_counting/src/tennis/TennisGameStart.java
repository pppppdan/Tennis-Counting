package tennis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TennisGameStart extends TennisGamePrintFormat {

	public ArrayList<String> ruleSelect() throws IOException {

		int set = 3;

		// ����, ���� ����
		boolean b = false;
		String input = "";
		do {
			if (b == true)
				System.out.println("\n\t�Է¿���! �ٽ� �������ּ���.");
			startScreenPrint();
			input = sc.next();
			if (input.equals("2")) {
				System.out.println();
				System.out.print("\t\t-���� ����-");
				System.exit(-1);

			}

		} while (b = !(input.matches("[1-2]")));

		// ����, ���� ����
		b = false;
		do {
			if (b == true)
				System.out.println("\n\t�Է¿���! �ٽ� �������ּ���.");
			matchPlayerGenderSelect();
			input = sc.next();
		} while (b = !(input.matches("[1-2]")));
		boolean gender = true;
		if (input.equals("2"))
			gender = false;

		// �ܽ�, ���� ����
		b = false;
		do {
			if (b == true)
				System.out.println("\n\t�Է¿���! �ٽ� �������ּ���.");
			matchSelect();
			input = sc.next();
		} while (b = !(input.matches("[1-2]")));
		int match = 1; // �ܽ�
		if (input.equals("2"))
			match = 2; // ����

		// ���� ����
		FileInOut fio = new FileInOut();
		ArrayList<String> mPlayerList = fio.getMPlayerName();
		ArrayList<String> wPlayerList = fio.getWPlayerName();
		ArrayList<String> teamA = new ArrayList<String>();
		ArrayList<String> teamB = new ArrayList<String>();
		ArrayList<String> player = new ArrayList<>();

		if (match == 1) { // �ܽ��̸�

			if (b == true)
				System.out.println("\n\t�Է¿���! �ٽ� �������ּ���.");
			if (gender == true) { // ���� �ܽ�
				playerSelect(mPlayerList);
				player = playerList(match, mPlayerList, teamA, teamB);
			} else { // ���� �ܽ�
				playerSelect(wPlayerList);
				player = playerList(match, wPlayerList, teamA, teamB);
			}

			System.out.print("\tTeam A - ");
			playerPrint(teamA);
			System.out.println();
			System.out.print("\tTeam B - ");
			playerPrint(teamB);
			System.out.println();

		} else { // �����̸�

			if (gender == true) { // ���� ����
				playerSelect(mPlayerList);
				player = playerList(match, mPlayerList, teamA, teamB);
			} else { // ���� ����
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
				System.out.println("\n\t�Է¿���! �ٽ� �������ּ���.");
			setMatchSelect();
			input = sc.next();
		} while (b = !(input.matches("[1-2]")));
		set = 5; // 5�� 3��
		if (input.equals("2"))
			set = 3; // 3�� 2��
		return set;
	}

	public boolean getTieBreak() {// Ÿ�̺극��ũ ����

		Scanner sc = new Scanner(System.in);
		String input = "";
		boolean tie;

		boolean b = false;
		do {
			if (b == true)
				System.out.println("\n\t�Է¿���! �ٽ� �������ּ���.");
			tieBreakSelect();
			input = sc.next();
		} while (b = !(input.matches("[1-2]")));
		tie = true; // Ÿ�̺극��ũ ����
		if (input.equals("2"))
			tie = false; // ������

		return tie;

	}

}// classpackage tennis;
