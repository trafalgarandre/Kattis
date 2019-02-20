import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_alphabet {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		int[] a = new int[s.length()];
		char[] c = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			a[i] = 1;
		}
		int max = 1;
		for (int i = s.length() - 2; i >= 0; i--) {
			for (int j = i + 1; j < s.length(); j++) {
				if (c[i] < c[j]) {
					a[i] = Math.max(a[i], a[j] + 1);
				}
			}
			max = Math.max(max, a[i]);
		}
		System.out.println(26 - max);
	}
}
