import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


public class kattis_variablearithmetic {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		while (!(s = reader.readLine()).equals("0")) {
			StringTokenizer tokenizer = new StringTokenizer(s);
			String left = tokenizer.nextToken();
			String middle = "";
			String right = "";
			if (tokenizer.hasMoreTokens()) {
				middle = tokenizer.nextToken();
				right = tokenizer.nextToken();
			}
			if (middle.equals("=")) {
				hm.put(left, Integer.parseInt(right));
			} else {
				tokenizer = new StringTokenizer(s);
				ArrayList<String> a = new ArrayList<String>();
				int result = 0;
				while (tokenizer.hasMoreTokens()) {
					String cur = tokenizer.nextToken();
					if (!cur.equals("+")) {
						if (cur.charAt(0) >= '0' && cur.charAt(0) <= '9') {
							result += Integer.parseInt(cur);
						} else if (hm.containsKey(cur)) {
							result += hm.get(cur);
						} else {
							a.add(cur);
						}
					}
				}
				if (result != 0) {
					System.out.print(result);
					for (int i = 0; i < a.size(); i++) {
						System.out.print(" + " + a.get(i));
					}
				} else {
					System.out.print(a.get(0));
					for (int i = 1; i < a.size(); i++) {
						System.out.print(" + " + a.get(i));
					}
				}
				System.out.println();
			}
		}
	}
}
