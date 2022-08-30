package tennis;

import java.util.ArrayList;

public class TennisSetWinner extends TennisRule {

	public void getSetWinner(int set, ArrayList<String> player, boolean tiebreak) {
		while ((setPoint[0] > setPoint[1] ? setPoint[0] : setPoint[1]) != set / 2 + 1) { // �¸� ��Ʈ ����ŭ �ݺ�

			while (!((gamePoint[0] > gamePoint[1] ? gamePoint[0] : gamePoint[1]) >= 6)) { // 6���� �¸� �� 1��Ʈ ����
				pointReset(playerPoint); // ����Ʈ �ʱ�ȭ
				getGameWinner(player);
				// ���� ����Ʈ ����
			}

			if ((gamePoint[0] > gamePoint[1] ? gamePoint[1] : gamePoint[0]) == 5) { // ���� �ེ �� �� �ݺ�
				while (true) { // �ེ
					pointReset(playerPoint); // ����Ʈ �ʱ�ȭ
					getGameWinner(player);

					if ((gamePoint[0] == gamePoint[1] && gamePoint[0] == 6) && tiebreak) {
						getTieBreakWinner(player, setPoint); // Ÿ�̺극��ũ ���� �� Ÿ�̺극��ũ ���� ����
						break;
					}
					// Ÿ�̺극��ũ ������� ���� �ེ ����

					if (Math.abs(gamePoint[0] - gamePoint[1]) == 2)
						break;
				}

			}
			if (gamePoint[0] > gamePoint[1])
				setPoint[0]++;

			else
				setPoint[1]++;

			// ���� ��������Ʈ ����
			pointReset(gamePoint); // ��������Ʈ �ʱ�ȭ

		}
		if ((playerPoint[0] > playerPoint[1] ? playerPoint[0] : playerPoint[1]) >= 6)
			dispTieBreakScoreBoard(player);
		else
			dispScoreBoard(player);
		System.out.println("���� ����");

	}

}
