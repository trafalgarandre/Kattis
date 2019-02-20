import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;


public class kattis_warehouse {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(reader.readLine());
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			for (int j = 0; j < n; j++) {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				String name = tokenizer.nextToken();
				int num = Integer.parseInt(tokenizer.nextToken());
				if (map.containsKey(name)) {
					map.put(name, map.get(name) + num);
				} else {
					map.put(name,  num);
				}
			}
			ArrayList<Toy> toys = new ArrayList<Toy>();
			for (Entry<String, Integer> entry: map.entrySet()) {
				toys.add(new Toy(entry.getValue(), entry.getKey()));
			}
			Collections.sort(toys);
			System.out.println(toys.size());
			for (Toy toy: toys) {
				System.out.println(toy.name + " " + toy.count);
			}
		}
	}
	static class Toy implements Comparable<Toy> {
		int count;
		String name;
		Toy(int _count, String _name) {
			count = _count;
			name = _name;
		}
		
		public int compareTo(Toy other) {
			if (this.count == other.count) {
				return this.name.compareTo(other.name);
			} else {
				return other.count - this.count;
			}
		}
	}
}
