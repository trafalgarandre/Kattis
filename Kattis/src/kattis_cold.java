import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_cold {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (Integer.parseInt(tokenizer.nextToken()) < 0) { 
				count++;
			}
		}
		System.out.println(count);
	}
}
