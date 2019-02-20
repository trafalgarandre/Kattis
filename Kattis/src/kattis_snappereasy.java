import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_snappereasy {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokenizer.nextToken());
			int k = Integer.parseInt(tokenizer.nextToken());
			int base_on = (int)Math.pow(2, n) - 1;
			if (k - base_on >= 0 && (k - base_on) % (base_on + 1) == 0) {
				System.out.println("Case #" + (i + 1) + ": ON");
			} else {
				System.out.println("Case #" + (i + 1) + ": OFF");
			}
		}
	}
}
