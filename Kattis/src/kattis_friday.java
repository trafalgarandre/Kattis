import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_friday {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int d = Integer.parseInt(tokenizer.nextToken());
			int m = Integer.parseInt(tokenizer.nextToken());
			tokenizer = new StringTokenizer(reader.readLine());
			int[] days = new int[m];
			for (int j = 0; j < m; j++) {
				days[j] = Integer.parseInt(tokenizer.nextToken());
			}
			int prev = 0;
			int count = 0;
			for (int j = 0; j < m; j++) {
				if (days[j] >= 13) {
					if (((prev + 13) - 6) % 7 == 0) {
						count++;
					}
				}
				prev += days[j];
			}
			System.out.println(count);
		}
	}
}
