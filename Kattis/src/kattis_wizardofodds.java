import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_wizardofodds {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		String s = tokenizer.nextToken();
		int k = Integer.parseInt(tokenizer.nextToken());
		String multi = "1";
		while (k > 0 && less(multi, s)) {
			multi = multi2(multi);
			k--;
		}
		if (less(multi, s)) {
			System.out.println("You will become a flying monkey!");
		} else {
			System.out.println("Your wish is granted!");
		}
	}
	
	static String multi2(String s) {
		char[] c = s.toCharArray();
		int mem = 0;
		for (int i = c.length - 1; i >= 0; i--) {
			int temp = c[i] - '0';
			int multi = temp * 2 + mem;
			mem = multi / 10;
			c[i] = (char)(multi % 10 + '0');
		}
		if (mem == 1) {
			return "1".concat(new String(c));
		} else {
			return new String(c);
		}
	}
	
	static boolean less (String s1, String s2) {
		if (s1.length() < s2.length()) {
			return true;
		} else if (s1.length() > s2.length()) {
			return false;
		} else {
			return s1.compareTo(s2) < 0;
		}
	}
}

