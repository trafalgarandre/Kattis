import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class kattis_simon {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			ArrayList<String> s = new ArrayList<String>();
			while (tokenizer.hasMoreTokens()) {
				s.add(tokenizer.nextToken());
			}
			if (s.size() > 2 && s.get(0).equals("simon") && s.get(1).equals("says")) {
				System.out.print(s.get(2));
				for (int j = 3; j < s.size(); j++) {
					System.out.print(" " + s.get(j));
				}
			}
			System.out.println();
		}
	}
}
