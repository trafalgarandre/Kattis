import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;




public class kattis_conversationlog {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		HashMap<String, HashSet<String>> hm = new HashMap<String, HashSet<String>>();
		HashMap<String, Integer> count = new HashMap<String, Integer>();
		HashSet<String> names = new HashSet<String>();
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			String name = tokenizer.nextToken();
			names.add(name);
			while (tokenizer.hasMoreTokens()) {
				String temp = tokenizer.nextToken();
				if (!hm.containsKey(temp)) {
					hm.put(temp, new HashSet<String>());
					count.put(temp, 0);
				}
				hm.get(temp).add(name);
				count.put(temp, count.get(temp) + 1);
			}
		}
		
		ArrayList<newString> a = new ArrayList<newString>();
		for (String s: hm.keySet()) {
			if (hm.get(s).size() == names.size()) {
				a.add(new newString(s, count.get(s)));
			}
		}
		Collections.sort(a);
		if (a.size() == 0) {
			System.out.println("ALL CLEAR");
		} else {
			for (newString s: a) {
				System.out.println(s.s);
			}
		}
	}
	
	static class newString implements Comparable<newString> {
		String s;
		int count;
		newString(String _s, int _count) {
			s = _s;
			count = _count;
		}
		
		public int compareTo(newString other) {
			if (this.count == other.count) {
				return s.compareTo(other.s);
			} else {
				return other.count - count;
			}
		}
	}
}
