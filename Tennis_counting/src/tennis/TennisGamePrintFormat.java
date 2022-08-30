package tennis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TennisGamePrintFormat {
static Scanner sc = new Scanner(System.in);

	public void startScreenPrint() {
		System.out.println("\n\t\t[ �״Ͻ� ���� ]\t\t\n");
		System.out.println("\t1. ���� ����");
		System.out.println("\t2. ���� ����");
		System.out.print("\n\t> ��ȣ �Է� : ");
	}

	public void matchPlayerGenderSelect() {
		System.out.println("\n\t���� ������ �������ּ���.");
		System.out.println("\t1. ����");
		System.out.println("\t2. ����");
		System.out.print("\n\t> ��ȣ �Է� : ");
	}

	public void matchSelect() {
		System.out.println("\n\t�ܽ�, ���� �������ּ���.");
		System.out.println("\t1. �ܽ�");
		System.out.println("\t2. ����");
		System.out.print("\n\t> ��ȣ �Է� : ");
	}

	public void setMatchSelect() {
		System.out.println("\n\t��Ʈ ���� �������ּ���.");
		System.out.println("\t1. 5�� 3��");
		System.out.println("\t2. 3�� 2��");
		System.out.print("\n\t> ��ȣ �Է� : ");
	}

	public void tieBreakSelect() {
		System.out.println("\n\tŸ�̺극��ũ ���� �������� �������ּ���.");
		System.out.println("\t1. Ÿ�̺극��ũ ����");
		System.out.println("\t2. Ÿ�̺극��ũ ������");
		System.out.print("\n\t> ��ȣ �Է� : ");
	}

	public void playerSelect(ArrayList<String> playerList) { // ���� ����, ���� ����Ʈ ���
		System.out.println("\n\t������ �������ּ���.");

		Iterator<String> ir = playerList.iterator();
		int i = 1;
		while (ir.hasNext()) {
			String mList = (String) ir.next();
			System.out.println("\t" + i + ". " + mList);
			++i;
		}
	}

	public void playerPrint(ArrayList<String> playerList) { // �� ���
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
			System.out.print("\t> Team A ���� �Է� : ");
			n = scanner.nextInt();
			if (count[n] > 0 || n > playerList.size()) {
				System.out.println("\t\t(�ߺ�����, ��� �� ���� ����) �ٽ��Է��ϼ���");
				i--;
			} else {
				name = playerList.get(n - 1);
				teamA.add(name);
				player.add(name);
				count[n]++;
			}
		}

		for (int i = 0; i < match; i++) {
			System.out.print("\t> Team B ���� �Է� : ");
			n = scanner.nextInt();
			if (count[n] > 0 || n > playerList.size()) {
				System.out.println("\t\t(�ߺ�����, ��� �� ���� ����) �ٽ��Է��ϼ���");
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