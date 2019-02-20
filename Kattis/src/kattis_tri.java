import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_tri {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int a = Integer.parseInt(tokenizer.nextToken());
		int b = Integer.parseInt(tokenizer.nextToken());
		int c = Integer.parseInt(tokenizer.nextToken());
		if (a + b == c) {
			System.out.println(a + "+" + b + "=" + c);
		} else if (a * b == c) {
			System.out.println(a + "*" + b + "=" + c);
		} else if (a - b == c) {
			System.out.println(a + "-" + b + "=" + c);
		} else if (a / b == c && a % b == 0) {
			System.out.println(a + "/" + b + "=" + c);
		} else if (a == b + c) {
			System.out.println(a + "=" + b + "+" + c);
		} else if (a == b - c) {
			System.out.println(a + "=" + b + "-" + c);
		} else if (a == b * c) {
			System.out.println(a + "=" + b + "*" + c);
		} else if (a == b / c && 0 == b % c) {
			System.out.println(a + "=" + b + "/" + c);
		}
	}
}
