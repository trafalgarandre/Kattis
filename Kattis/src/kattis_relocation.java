import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_relocation {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int q = Integer.parseInt(tokenizer.nextToken());
		int[] a = new int[n];
		tokenizer = new StringTokenizer(reader.readLine());
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(tokenizer.nextToken());
		}
		for (int i = 0; i < q; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int type = Integer.parseInt(tokenizer.nextToken());
			int x = Integer.parseInt(tokenizer.nextToken());
			int y = Integer.parseInt(tokenizer.nextToken());
			if (type == 1) {
				a[x - 1] = y;
			} else {
				System.out.println(Math.abs(a[x - 1] - a[y - 1]));
			}
		}
	}
}
