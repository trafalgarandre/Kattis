import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_trik {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int cur = 1;
		for (char c: reader.readLine().toCharArray()) {
			if (c == 'A') {
				if (cur == 1) {
					cur = 2;
				} else if (cur == 2) {
					cur = 1;
				}
			} else if (c == 'B') {
				if (cur == 2) {
					cur = 3;
				} else if (cur == 3) {
					cur = 2;
				}
			} else if (c == 'C') {
				if (cur == 1) {
					cur = 3;
				} else if (cur == 3) {
					cur = 1;
				}
			}
		}
		System.out.println(cur);
	}
}
