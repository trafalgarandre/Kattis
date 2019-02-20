import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class kattis_cups {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		ArrayList<Cup> cups = new ArrayList<Cup>();
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			String first = tokenizer.nextToken();
			String second = tokenizer.nextToken();
			if (first.charAt(0) >= 'a' && first.charAt(0) <= 'z') {
				cups.add(new Cup(Integer.parseInt(second) * 2, first));
			} else {
				cups.add(new Cup(Integer.parseInt(first), second));
			}
		}
		Collections.sort(cups);
		for (Cup cup: cups) {
			System.out.println(cup.name);
		}
	}
	static class Cup implements Comparable<Cup>{
		int val;
		String name;
		Cup(int val_, String name_) {
			val = val_;
			name = name_;
		}
		
		public int compareTo(Cup other) {
			return this.val - other.val;
		}
	}
}
