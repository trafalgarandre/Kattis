import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_teacherevaluation {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int p = Integer.parseInt(tokenizer.nextToken());
		tokenizer = new StringTokenizer(reader.readLine());
		int total = 0;
		for (int i = 0; i < n; i++) {
			total += Integer.parseInt(tokenizer.nextToken());
		}
		int t = 0;
		int prev = -1;
		boolean check = true;
		if (p * (n + t) - total > 100 * t) {
			t++;
		}
		while (p * (n + t) - total > 100 * t) {
			if (prev == -1) {
				prev = (p * (n + t) - total) - t * 100;
			} else {
				int temp = (p * (n + t) - total) - t * 100;
				if (prev <= temp) {
					check = false;
					break;
				}
			}
			t++;
		}
		System.out.println(check ? t : "impossible");
	}
}
