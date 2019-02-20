import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_vauvau {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int a = Integer.parseInt(tokenizer.nextToken());
		int b = Integer.parseInt(tokenizer.nextToken());
		int c = Integer.parseInt(tokenizer.nextToken());
		int d = Integer.parseInt(tokenizer.nextToken());
		tokenizer = new StringTokenizer(reader.readLine());
		int p = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		int g = Integer.parseInt(tokenizer.nextToken());
		int count = 0;
		if (p % (a + b) <= a && p % (a + b) > 0) {
			count++;
		}
		if (p % (c + d) <= c && p % (c + d) > 0) {
			count++;
		}
		if (count == 0) {
			System.out.println("none");
		} else if (count == 1) {
			System.out.println("one");
		} else {
			System.out.println("both");
		}
		
		count = 0;
		if (m % (a + b) <= a && m % (a + b) > 0) {
			count++;
		}
		if (m % (c + d ) <= c && m % (c + d) > 0) {
			count++;
		}
		if (count == 0) {
			System.out.println("none");
		} else if (count == 1) {
			System.out.println("one");
		} else {
			System.out.println("both");
		}
		
		count = 0;
		if (g % (a + b) <= a && g % (a + b) > 0) {
			count++;
		}
		if (g % (c + d ) <= c && g % (c + d) > 0) {
			count++;
		}
		if (count == 0) {
			System.out.println("none");
		} else if (count == 1) {
			System.out.println("one");
		} else {
			System.out.println("both");
		}
	}
}
