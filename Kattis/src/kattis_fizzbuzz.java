import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_fizzbuzz {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int x = Integer.parseInt(tokenizer.nextToken());
		int y = Integer.parseInt(tokenizer.nextToken());
		int n = Integer.parseInt(tokenizer.nextToken());
		for (int i = 1 ;i <= n; i++) {
			if (i % x != 0 && i % y != 0) {
				System.out.println(i);
			} else {
				if (i % x == 0) {
					System.out.print("Fizz");
				}
				if (i % y == 0) {
					System.out.print("Buzz");
				}
				System.out.println();
			}
		}
	}
}
