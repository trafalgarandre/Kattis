import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_snapperhard {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		long[] base = new long[30];
		for (int i = 0; i < 30; i++) {
			base[i] = (long)Math.pow(2, i + 1) - 1;
		}
		
		for (int i = 0; i < t; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokenizer.nextToken());
			long k = Integer.parseInt(tokenizer.nextToken());
			if (k - base[n - 1] >= 0 && (k - base[n - 1]) % (base[n - 1] + 1) == 0) {
				System.out.println("Case #" + (i + 1) + ": ON");
			} else {
				System.out.println("Case #" + (i + 1) + ": OFF");
			}
		}
	}
}
