import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_freefood {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean[] check = new boolean[366];
		int n = Integer.parseInt(reader.readLine());
		int count = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(tokenizer.nextToken());
			int t = Integer.parseInt(tokenizer.nextToken());
			for (int j = s; j <= t; j++) {
				if (!check[j]) {
					check[j] = true;
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
