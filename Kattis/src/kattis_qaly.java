import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_qaly {
	public static void main(String agrs[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		double total = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			total = total + Double.parseDouble(tokenizer.nextToken())
					* Double.parseDouble(tokenizer.nextToken());
		}
		System.out.println(total);
	}
}
