import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_thanos {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			long p = Long.parseLong(tokenizer.nextToken());
			long r = Long.parseLong(tokenizer.nextToken());
			long f = Long.parseLong(tokenizer.nextToken());
			int time = 0;
			while (p <= f) {
				p = p * r;
				time++;
			}
			System.out.println(time);
		}
	}
}
