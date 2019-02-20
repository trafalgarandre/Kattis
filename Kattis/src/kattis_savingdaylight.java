import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_savingdaylight {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = reader.readLine()) != null && s.length() != 0) {
			StringTokenizer tokenizer = new StringTokenizer(s);
			System.out.print(tokenizer.nextToken() + " " + tokenizer.nextToken() + " " + tokenizer.nextToken() + " ");
			StringTokenizer tokenizer2 = new StringTokenizer(tokenizer.nextToken());
			int start = 60 * Integer.parseInt(tokenizer2.nextToken(":")) + Integer.parseInt(tokenizer2.nextToken(":"));
			tokenizer2 = new StringTokenizer(tokenizer.nextToken());
			int end = 60 * Integer.parseInt(tokenizer2.nextToken(":")) + Integer.parseInt(tokenizer2.nextToken(":"));
			int left = end - start;
			System.out.println((left / 60) + " hours " + (left % 60) + " minutes");
		}
	}
}
