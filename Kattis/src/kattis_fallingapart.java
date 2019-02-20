import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class kattis_fallingapart {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(tokenizer.nextToken());
		}
		Arrays.sort(a);
		int[] b = new int[2];
		int temp = 0;
		for (int i = n - 1; i >= 0; i--) {
			b[temp] += a[i];
			temp = (temp + 1) % 2;
		}
		System.out.println(b[0] + " " + b[1]);
	}
}
