import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class kattis_sidewayssorting {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int r = Integer.parseInt(tokenizer.nextToken());
		int c = Integer.parseInt(tokenizer.nextToken());
		while (r != 0 || c != 0) {
			ArrayList<newString> strings = new ArrayList<newString>();
			String[] str = new String[r];
			for (int i = 0; i < r; i++) {
				str[i] = reader.readLine();
			}
			for (int i = 0; i < c; i++) {
				char[] cs = new char[r];
				for (int j = 0; j < r; j++) {
					cs[j] = str[j].charAt(i);
				}
				strings.add(new newString(new String(cs)));
			}
			Collections.sort(strings);
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					System.out.print(strings.get(j).charAt(i));
				}
				System.out.println();
			}
			tokenizer = new StringTokenizer(reader.readLine());
			r = Integer.parseInt(tokenizer.nextToken());
			c = Integer.parseInt(tokenizer.nextToken());
			if (r != 0 || c != 0) {
				System.out.println();
			}
		}
	}
	
	static class newString implements Comparable<newString> {
		String s;
		newString(String _s) {
			s = _s;
		}
		
		public char charAt(int pos) {
			return s.charAt(pos);
		}
		
		public int compareTo(newString other) {
			String first = this.s.toLowerCase();
			String second = other.s.toLowerCase();
			return first.compareTo(second);
		}
	}
}
