import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class kattis_woodcutting {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(reader.readLine());
			int[] a = new int[n];
			for (int j = 0; j < n; j++) {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				int w = Integer.parseInt(tokenizer.nextToken());
				for (int k = 0; k < w; k++) {
					a[j] += Integer.parseInt(tokenizer.nextToken());
				}
			}
			Arrays.sort(a);
			double temp = 0;
			double total = 0;
			for (int k = 0; k < a.length; k++) {
				temp += a[k];
				total += temp;
			}
			System.out.println(total / n);
		}
	}
}
