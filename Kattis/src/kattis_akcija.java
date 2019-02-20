import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class kattis_akcija {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(reader.readLine());
		}
		Arrays.sort(a);
		long total = 0;
		int count = 0;
		for (int i = n - 1; i >= 0; i--) {
			count++;
			if (count < 3) {
				total += a[i];
			} else {
				count = 0;
			}
		}
		System.out.println(total);
	}
}
