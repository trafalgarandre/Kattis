import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_primaryarithmetic {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		String s1 = tokenizer.nextToken();
		String s2 = tokenizer.nextToken();
		while (!s1.equals("0") || (!s2.equals("0"))) {
			int result = plusReturnCarry(s1, s2);
			if (result == 0) {
				System.out.println("No carry operation.");
			} else if (result == 1) {
				System.out.println("1 carry operation.");
			} else {
				System.out.println(result + " carry operations.");
			}
			tokenizer = new StringTokenizer(reader.readLine());
			s1 = tokenizer.nextToken();
			s2 = tokenizer.nextToken();
		}
	}
	
	static int plusReturnCarry(String s1, String s2) {
		while (s1.length() < s2.length()) {
			s1 = "0" + s1;
		}
		while (s1.length() > s2.length()) {
			s2 = "0" + s2;
		}
		int count = 0;
		int mem = 0;
		for (int i = s1.length() - 1; i >= 0; i--) {
			int plus = s1.charAt(i) - '0' + s2.charAt(i) - '0' + mem;
			mem = plus / 10;
			if (mem != 0) {
				count++;
			}
		}
		return count;
	}
}
