import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_grassseed {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		double c = Double.parseDouble(reader.readLine());
		int n = Integer.parseInt(reader.readLine());
		double total = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			total += Double.parseDouble(tokenizer.nextToken()) * Double.parseDouble(tokenizer.nextToken()) * c;
		}
		System.out.println(total);
	}
}
