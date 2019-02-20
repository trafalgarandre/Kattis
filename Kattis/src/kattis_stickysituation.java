import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class kattis_stickysituation {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		long[] a = new long[n];
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(tokenizer.nextToken());
		}
		Arrays.sort(a);
		boolean can = false;
		for (int i = 0; i < n - 2; i++) {
			if (a[i] + a[i + 1] > a[i + 2]) {
				can = true;
			}
		}
		System.out.println(can ? "possible" : "impossible");
	}
}
