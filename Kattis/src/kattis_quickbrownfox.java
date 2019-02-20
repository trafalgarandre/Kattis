import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kattis_quickbrownfox {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		for (int i = 0; i < n; i++) {
			boolean[] check = new boolean[26];
			String s = (reader.readLine()).toLowerCase();
			int count = 0;
			for (char c: s.toCharArray()) {
				if (c >= 'a' && c <= 'z' && !check[c - 'a']) {
					check[c - 'a'] = true;
					count++;
				}
			}
			if (count == 26) {
				System.out.println("pangram");
			} else {
				System.out.print("missing ");
				for (int j = 0; j < 26; j++) {
					if (!check[j]) {
						System.out.print((char)(j + 'a'));
					}
				}
				System.out.println();
			}
		}
	}
}
