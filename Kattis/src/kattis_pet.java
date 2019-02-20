import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_pet {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		int i_max = 0;
		for (int i = 0; i < 5; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int total = Integer.parseInt(tokenizer.nextToken()) + Integer.parseInt(tokenizer.nextToken())
					+ Integer.parseInt(tokenizer.nextToken()) + Integer.parseInt(tokenizer.nextToken());
			if (total > max) {
				max = total;
				i_max = i + 1;
			}
		}
		System.out.println(i_max + " " + max);
	}
}
