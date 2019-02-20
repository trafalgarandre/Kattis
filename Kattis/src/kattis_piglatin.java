import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_piglatin {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = reader.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(s);
			while (tokenizer.hasMoreTokens()) {
				String s2 = tokenizer.nextToken();
				char first = s2.charAt(0);
				if (check(first)) {
					System.out.print(s2 + "yay");
				} else {
					int pos = 1;
					while (pos < s2.length() && !check(s2.charAt(pos))) {
						pos++;
					}
					if (pos != s2.length()) {
						System.out.print(s2.substring(pos, s2.length()) 
								+ s2.substring(0, pos) + "ay");
					} else {
						System.out.print(s2 + "ay");
					}
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static boolean check(char first) {
		return first == 'a' || first == 'e' || first == 'i' || first == 'o'
				|| first == 'u' || first == 'y';
	}
}
