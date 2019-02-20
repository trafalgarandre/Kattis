import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_neighborhoodwatch {
	public static void main(String args[]) throws NumberFormatException, IOException {
		long[] prepare = new long[200001];
		prepare[0] = 0;
		for (int i = 1; i < 200001; i++) {
			prepare[i] = prepare[i - 1] + i;
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int p = Integer.parseInt(tokenizer.nextToken());
		long total = prepare[n];
		int left = 1;
		for (int i = 0; i < p; i++) {
			int temp = Integer.parseInt(reader.readLine());
			total -= prepare[temp - left];
			left = temp + 1;
		}
		if (left < n + 1) {
			total -= prepare[n + 1 - left];
		}
		System.out.println(total);
	}
}
