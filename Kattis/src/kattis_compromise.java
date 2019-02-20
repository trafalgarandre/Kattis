import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_compromise {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer;
		for (int i = 0; i < t; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokenizer.nextToken());
			int m = Integer.parseInt(tokenizer.nextToken());
			int[] a0 = new int[m];
			int[] a1 = new int[m];
			for (int j = 0; j < n; j++) {
				String str = reader.readLine();
				for (int k = 0; k < str.length(); k++) {
					if (str.charAt(k) == '0') {
						a0[k]++;
					} else {
						a1[k]++;
					}
				}
			}
			for (int j = 0; j < m; j++) {
				if (a0[j] > a1[j]) {
					System.out.print('0');
				} else {
					System.out.print('1');
				}
			}
			System.out.println();
		}
	}
}
