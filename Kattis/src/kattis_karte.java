import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_karte {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		boolean[] p = new boolean[14];
		boolean[] k = new boolean[14];
		boolean[] h = new boolean[14];
		boolean[] t = new boolean[14];
		boolean greska = false;
		for (int i = 0; i < s.length() / 3; i++) {
			int number = 10 * (s.charAt(i * 3 + 1) - '0') + (s.charAt(i * 3 + 2) - '0'); 
			if (s.charAt(i * 3) == 'P') {
				if (p[number]) {
					greska = true;
				} else {
					p[number] = true;
				}
			} else if (s.charAt(i * 3) == 'K') {
				if (k[number]) {
					greska = true;
				} else {
					k[number] = true;
				}
			} else if (s.charAt(i * 3) == 'H') {
				if (h[number]) {
					greska = true;
				} else {
					h[number] = true;
				}
			} else {
				if (t[number]) {
					greska = true;
				} else {
					t[number] = true;
				}
			}
		}
		if (greska) {
			System.out.println("GRESKA");
		} else {
			int count = 0;
			for (int i = 1; i < 14; i++) {
				if (p[i]) {
					count++;
				}
			}
			System.out.print((13 - count) + " ");
			count = 0;
			for (int i = 1; i < 14; i++) {
				if (k[i]) {
					count++;
				}
			}
			System.out.print((13 - count) + " ");
			count = 0;
			for (int i = 1; i < 14; i++) {
				if (h[i]) {
					count++;
				}
			}
			System.out.print((13 - count) + " ");
			count = 0;
			for (int i = 1; i < 14; i++) {
				if (t[i]) {
					count++;
				}
			}
			System.out.print(13 - count);
		}
	}
}
