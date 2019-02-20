import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_pivot {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(tokenizer.nextToken());
		}
		int[] rmin = new int[n];
		int[] lmax = new int[n];
		int min = Integer.MAX_VALUE;
		for (int i = n - 1; i >= 0; i--) {
			if (min > a[i]) {
				min = a[i];
			}
			rmin[i] = min;
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (max < a[i]) {
				max = a[i];
			}
			lmax[i] = max;
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				if (a[i] <= rmin[i]) {
					count++;
				}
			} else if (i == n - 1) {
				if (a[i] >= lmax[i]) {
					count++;
				}
			} else {
				if (a[i] <= rmin[i] && a[i] >= lmax[i]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
