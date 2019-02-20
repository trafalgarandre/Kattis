import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_aboveaverage {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(reader.readLine());
		for (int i = 0; i < c; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokenizer.nextToken());
			int[] a = new int[n];
			int sum = 0;
			for (int j = 0; j < n; j++) {
				a[j] = Integer.parseInt(tokenizer.nextToken());
				sum += a[j];
			}
			int average = sum / n;
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (a[j] > average) {
					count++;
				}
			}
			double result = (double) count / (double) n * 100;
			System.out.printf("%.3f%%\n", result);
		}
	}
}
