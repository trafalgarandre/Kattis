import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_trollhunt {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int b = Integer.parseInt(tokenizer.nextToken());
		int k = Integer.parseInt(tokenizer.nextToken());
		int g = Integer.parseInt(tokenizer.nextToken());
		int group = k / g;
		int days = 0;
		while (b > 1) {
			days++;
			b -= group;
		}
		System.out.println(days);
	}
}
