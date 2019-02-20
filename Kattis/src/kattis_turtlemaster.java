import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_turtlemaster {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[][] board = new char[8][8];
		for (int i = 0; i < 8; i++) {
			String s = reader.readLine();
			for (int j = 0; j < 8; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		int pos_i = 7;
		int pos_j = 0;
		//0 up, 1 right
		int dir = 1;
		boolean isRight = true;
		for (char c: reader.readLine().toCharArray()) {
			if (c == 'F') {
				int new_i, new_j;
				if (dir == 0) {
					new_i = pos_i - 1;
					new_j = pos_j;
				} else if (dir == 1) {
					new_i = pos_i;
					new_j = pos_j + 1;
				} else if (dir == 2) {
					new_i = pos_i + 1;
					new_j = pos_j;
				} else {
					new_i = pos_i;
					new_j = pos_j - 1;
				}
				if (new_i < 0 || new_j > 7 || new_j < 0 || new_i > 7 
						|| board[new_i][new_j] == 'C' || board[new_i][new_j] == 'I') {
					isRight = false;
					break;
				}
				pos_i = new_i;
				pos_j = new_j;
			} else if (c == 'R') {
				dir = (dir + 1) % 4;
			} else if (c == 'L') {
				dir = (dir + 4 - 1) % 4;
			} else {
				int new_i, new_j;
				if (dir == 0) {
					new_i = pos_i - 1;
					new_j = pos_j;
				} else if (dir == 1) {
					new_i = pos_i;
					new_j = pos_j + 1;
				} else if (dir == 2) {
					new_i = pos_i + 1;
					new_j = pos_j;
				} else {
					new_i = pos_i;
					new_j = pos_j - 1;
				}
				if (new_i >= 0 && new_i <= 7 && new_j >= 0 && new_j <= 7
						&& board[new_i][new_j] == 'I') {
					board[new_i][new_j] = '.';
				} else {
					isRight = false;
					break;
				}
			}
		}
		if (isRight && board[pos_i][pos_j] == 'D') {
			System.out.println("Diamond!");
		} else {
			System.out.println("Bug!");
		}
	}
}
