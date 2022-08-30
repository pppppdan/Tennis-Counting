package tennis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TennisGamePrintFormat {
static Scanner sc = new Scanner(System.in);

	public void startScreenPrint() {
		System.out.println("\n\t\t[ 테니스 게임 ]\t\t\n");
		System.out.println("\t1. 게임 시작");
		System.out.println("\t2. 게임 종료");
		System.out.print("\n\t> 번호 입력 : ");
	}

	public void matchPlayerGenderSelect() {
		System.out.println("\n\t선수 성별을 선택해주세요.");
		System.out.println("\t1. 남자");
		System.out.println("\t2. 여자");
		System.out.print("\n\t> 번호 입력 : ");
	}

	public void matchSelect() {
		System.out.println("\n\t단식, 복식 선택해주세요.");
		System.out.println("\t1. 단식");
		System.out.println("\t2. 복식");
		System.out.print("\n\t> 번호 입력 : ");
	}

	public void setMatchSelect() {
		System.out.println("\n\t세트 수를 선택해주세요.");
		System.out.println("\t1. 5판 3선");
		System.out.println("\t2. 3판 2선");
		System.out.print("\n\t> 번호 입력 : ");
	}

	public void tieBreakSelect() {
		System.out.println("\n\t타이브레이크 룰을 적용할지 선택해주세요.");
		System.out.println("\t1. 타이브레이크 적용");
		System.out.println("\t2. 타이브레이크 미적용");
		System.out.print("\n\t> 번호 입력 : ");
	}

	public void playerSelect(ArrayList<String> playerList) { // 선수 선택, 선수 리스트 출력
		System.out.println("\n\t선수를 선택해주세요.");

		Iterator<String> ir = playerList.iterator();
		int i = 1;
		while (ir.hasNext()) {
			String mList = (String) ir.next();
			System.out.println("\t" + i + ". " + mList);
			++i;
		}
	}

	public void playerPrint(ArrayList<String> playerList) { // 팀 출력
		Iterator<String> ir = playerList.iterator();
		while (ir.hasNext()) {
			String mList = (String) ir.next();
			System.out.print(mList + " ");
		}
	}


	public ArrayList<String> playerList(int match, ArrayList<String> playerList, ArrayList<String> teamA, ArrayList<String> teamB) {
		ArrayList<String> player = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int n;
		String name;
		int[] count = new int[100];

		System.out.println();
		for (int i = 0; i < match; i++) {
			System.out.print("\t> Team A 선수 입력 : ");
			n = scanner.nextInt();
			if (count[n] > 0 || n > playerList.size()) {
				System.out.println("\t\t(중복선택, 명단 외 선택 금지) 다시입력하세요");
				i--;
			} else {
				name = playerList.get(n - 1);
				teamA.add(name);
				player.add(name);
				count[n]++;
			}
		}

		for (int i = 0; i < match; i++) {
			System.out.print("\t> Team B 선수 입력 : ");
			n = scanner.nextInt();
			if (count[n] > 0 || n > playerList.size()) {
				System.out.println("\t\t(중복선택, 명단 외 선택 금지) 다시입력하세요");
				i--;
			} else {
				name = playerList.get(n - 1);
				teamB.add(name);
				player.add(name);
				count[n]++;
			}

		}
		return player;
	}

}

// class Print