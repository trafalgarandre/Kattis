import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_toilet {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		char cur;
		cur = str.charAt(0);
		int alwaysup = 0;
		int alwaysdown = 0;
		int alwaysleave = 0;
		for (int i = 1; i < str.length(); i++) {
			char temp = str.charAt(i);
			if (cur != temp) {
				alwaysup++;
			}
			if (temp == 'D') {
				alwaysup++;
			}
			cur = 'U';
		}
		System.out.println(alwaysup);
		cur = str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			char temp = str.charAt(i);
			if (cur != temp) {
				alwaysdown++;
			}
			if (temp == 'U') {
				alwaysdown++;
			}
			cur = 'D';
		}
		System.out.println(alwaysdown);
		cur = str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			char temp = str.charAt(i);
			if (cur != temp) {
				alwaysleave += 1;
			}
			cur = temp;
		}
		System.out.println(alwaysleave);
	}
}
