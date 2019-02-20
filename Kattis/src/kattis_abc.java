import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class kattis_abc {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int[] a = new int[3];
		for (int i = 0; i < 3; i++) {
			a[i] = Integer.parseInt(tokenizer.nextToken());
		}
		Arrays.sort(a);
		String s = reader.readLine();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A') {
				System.out.print(a[0]);
			} else if (s.charAt(i) == 'B') {
				System.out.print(a[1]);
			} else {
				System.out.print(a[2]);
			}
			if (i != 2) {
				System.out.print(" ");	
			}
		}
	}
}
