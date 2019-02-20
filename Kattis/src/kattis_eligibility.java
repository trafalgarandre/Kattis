import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_eligibility {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			int check = 0;
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			System.out.print(tokenizer.nextToken() + " ");
			StringTokenizer tokenizer2 = new StringTokenizer(tokenizer.nextToken());
			String ps = tokenizer2.nextToken("/");
			if (Integer.parseInt(ps) >= 2010) {
				check = 1;
			}
			tokenizer2 = new StringTokenizer(tokenizer.nextToken());
			String born = tokenizer2.nextToken("/");
			if (Integer.parseInt(born) >= 1991) {
				check = 1;
			}
			Integer semester = Integer.parseInt(tokenizer.nextToken());
			if (check == 0 && semester >= 41) {
				check = 2;
			}
			if (check == 0) {
				System.out.println("coach petitions");
			} else if (check == 1) {
				System.out.println("eligible");
			} else {
				System.out.println("ineligible");
			}
		}
	}
}
