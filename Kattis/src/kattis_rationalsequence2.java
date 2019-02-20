import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_rationalsequence2 {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			System.out.print(Integer.parseInt(tokenizer.nextToken()));
			tokenizer = new StringTokenizer(tokenizer.nextToken());
			int p = Integer.parseInt(tokenizer.nextToken("/"));
			int q = Integer.parseInt(tokenizer.nextToken());
			System.out.println(" " + work(p, q));
		}
		
	}
	
	public static int work(int p, int q) {
		if (p == 1 && q == 1) {
			return 1;
		} else {
			if (p > q) {
				return work(p - q, q) * 2 + 1;
			} else {
				return work(p, q - p) * 2;
			}
		}
	}
}
