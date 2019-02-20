import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_filip {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int a = Integer.parseInt(tokenizer.nextToken());
		int b = Integer.parseInt(tokenizer.nextToken());
		int a2 = 0;
		while (a > 0) {
			a2 = a2 * 10 + a % 10;
			a /= 10;
		}
		int b2 = 0;
		while (b > 0) {
			b2 = b2 * 10 + b % 10;
			b /= 10;
		}
		System.out.println(Math.max(a2, b2));
	}
}
