import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_alphabetspam {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		int whitespace = 0;
		int lower = 0;
		int upper = 0;
		int symbol = 0;
		for (char c: s.toCharArray()) {
			if (c == '_') {
				whitespace++;
			} else if (c >= 'a' && c <= 'z') {
				lower++;
			} else if (c >= 'A' && c <= 'Z') {
				upper++;
			} else {
				symbol++;
			}
		}
		int total = whitespace + lower + upper + symbol;
		double out1 = (double)whitespace / (double)total;
		double out2 = (double)lower / (double)total;
		double out3 = (double)upper / (double)total;
		double out4 = (double)symbol / (double)total;
		System.out.println(out1);
		System.out.println(out2);
		System.out.println(out3);
		System.out.println(out4);
	}
}
