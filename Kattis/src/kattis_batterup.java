import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_batterup {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int points = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			int cur = Integer.parseInt(tokenizer.nextToken());
			if (cur != -1) {
				points += cur;
				count++;
			}
		}
		System.out.println((double)points / (double)count);
	}
}
