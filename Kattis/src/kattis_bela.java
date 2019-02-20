import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_bela {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		char trump = tokenizer.nextToken().charAt(0);
		int value = 0;
		for (int i = 0; i < 4 * n; i++) {
			String s = reader.readLine();
			char c1 = s.charAt(0);
			char c2 = s.charAt(1);
			if (c1 == 'K') {
				value += 4;
			} else if (c1 == 'Q') {
				value += 3;
			} else if (c1 == 'T') {
				value += 10;
			} else if (c1 == 'A') {
				value += 11;
			} else if (c1 == 'J') {
				if (c2 == trump) {
					value += 20;
				} else {
					value += 2;
				}
			} else if (c1 == '9' && c2 == trump) {
				value += 14;
			}		
		}
		System.out.println(value);
	}
}
