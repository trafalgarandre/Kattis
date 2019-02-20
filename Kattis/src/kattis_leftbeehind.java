import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_leftbeehind {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int x = Integer.parseInt(tokenizer.nextToken());
		int y = Integer.parseInt(tokenizer.nextToken());
		while (x != 0 || y != 0) {
			if (x + y == 13) {
				System.out.println("Never speak again.");
			} else if (x < y) {
				System.out.println("Left beehind.");
			} else if (x > y) {
				System.out.println("To the convention.");
			} else {
				System.out.println("Undecided.");
			}
			tokenizer = new StringTokenizer(reader.readLine());
			x = Integer.parseInt(tokenizer.nextToken());
			y = Integer.parseInt(tokenizer.nextToken());
		}
	}
}
