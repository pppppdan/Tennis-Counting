package tennis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileInOut {

	public ArrayList<Player> getPlayer() throws IOException {

		String pathname = "C:\\Class\\JavaClass\\javaPro\\src\\tennis\\res\\tennisGame.txt";
		File f = new File(pathname);
		ArrayList<Player> list = new ArrayList<Player>();

		try (BufferedReader br = new BufferedReader(new FileReader(f));) {
			String line;
			while ((line = br.readLine()) != null) {
				// System.out.println(line);
				String[] array = line.split(" ");

				int playerNumber = Integer.parseInt(array[0]);
				String name = array[1];

				boolean gender;
				if (array[2].equals("³²ÀÚ"))
					gender = true;
				else
					gender = false;

				Player p1 = new Player(playerNumber, name, gender);
				list.add(p1);

			}

		} catch (Exception e) {
			// e.printStackTrace();
		}

		return list;
	}

	public ArrayList<String> getMPlayerName() throws IOException {
		ArrayList<Player> list = getPlayer();
		ArrayList<String> mPlayerName = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getGender())
				mPlayerName.add(list.get(i).getName());
		}

		return mPlayerName;
	}

	public ArrayList<String> getWPlayerName() throws IOException {
		ArrayList<Player> list = getPlayer();
		ArrayList<String> wPlayerName = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).getGender())
				wPlayerName.add(list.get(i).getName());
		}

		return wPlayerName;
	}

}

class Player {
	private int playerNumber;
	private String name;
	private boolean gender;

	public int getPlayerNumber() {
		return playerNumber;

	}

	public Player(int playerNumber, String name, boolean gender) {
		super();
		this.playerNumber = playerNumber;
		this.name = name;
		this.gender = gender;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Player [playerNumber=" + playerNumber + ", name=" + name + ", gender=" + gender + "]";
	}
}
