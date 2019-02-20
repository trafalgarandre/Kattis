import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_trainpassengers {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int c = Integer.parseInt(tokenizer.nextToken());
		int n = Integer.parseInt(tokenizer.nextToken());
		int cur = 0;
		boolean check = true;
		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			cur -= Integer.parseInt(tokenizer.nextToken());
			if (cur < 0) {
				check = false;
				break;
			}
			cur += Integer.parseInt(tokenizer.nextToken());
			if (cur > c) {
				check = false;
				break;
			}
			if (Integer.parseInt(tokenizer.nextToken()) != 0 && (cur != c || i == n - 1)) {
				check = false;
				break;
			}
		}
		if (cur != 0) {
			check = false;
		}
		
		if (check) {
			System.out.println("possible");
		} else {
			System.out.println("impossible");
		}
	}
}
