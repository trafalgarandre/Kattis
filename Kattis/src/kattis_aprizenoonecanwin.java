import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class kattis_aprizenoonecanwin {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int x = Integer.parseInt(tokenizer.nextToken());
		int[] a = new int[n];
		tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(tokenizer.nextToken());
		}
		Arrays.sort(a);
		int min = 0;
		int temp = 0;
		while (temp < n && (a[temp] + min <= x || min == 0)) {
			min = a[temp];
			temp++;
		}
		System.out.println(temp);
	}
}
