import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_baloni {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int[] a = new int[1000001];
		int count = 0;
		for (int i = 0; i < n; i++) {
			int cur = Integer.parseInt(tokenizer.nextToken());
			if (i == 0 || a[cur + 1] == 0) {
				count++;
			} else {
				a[cur + 1]--;
			}
			a[cur]++;
		}
		System.out.println(count);
	}
}
