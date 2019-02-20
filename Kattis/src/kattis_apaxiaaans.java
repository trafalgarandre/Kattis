import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_apaxiaaans {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		char prev = s.charAt(0);
		System.out.print(prev);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) != prev) {
				prev = s.charAt(i);
				System.out.print(prev);
			}
		}
	}
}
