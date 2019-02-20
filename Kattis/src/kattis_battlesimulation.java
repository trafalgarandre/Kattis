import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_battlesimulation {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		int left = 0;
		
		while (left < s.length()) {
			if (left + 2 < s.length()) {
				int total = changeNum(s.charAt(left)) + changeNum(s.charAt(left + 1)) + changeNum(s.charAt(left + 2));
				if (total == 8) {
					System.out.print('C');
					left += 3;
				} else {
					System.out.print(changeChar(s.charAt(left)));
					left++;
				}
			} else {
				System.out.print(changeChar(s.charAt(left)));
				left++;
			}
		}
	}
	
	public static int changeNum(char c) {
		if (c == 'R') {
			return 1;
		} else if (c == 'L') {
			return 2;
		} else {
			return 5;
		}
	}
	
	public static char changeChar(char c) {
		if (c == 'R') {
			return 'S';
		} else if (c == 'B') {
			return 'K';
		} else {
			return 'H';
		}
	}
}
