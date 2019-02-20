import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;


public class kattis_guessinggame {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n;
		BitSet check = new BitSet(11);
		while ((n = Integer.parseInt(reader.readLine())) != 0) {
			String s = reader.readLine();
			if (s.equals("right on")) {
				if (check.get(n)) {
					System.out.println("Stan is dishonest");
				} else {
					System.out.println("Stan may be honest");
				}
				check.clear();
			} else {
				if (s.equals("too high")) {
					check.set(n, 11);
				} else {
					check.set(1, n + 1);
				}
			}
		}
	}
}
