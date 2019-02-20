import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;


public class kattis_grandpabernie {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		HashMap<String, ArrayList<Integer>> hm = new HashMap<String, ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			String name = tokenizer.nextToken();
			if (!hm.containsKey(name)) {
				hm.put(name, new ArrayList<Integer>());
			}
			hm.get(name).add(Integer.parseInt(tokenizer.nextToken()));
		}
		n = Integer.parseInt(reader.readLine());
		for (String s: hm.keySet()) {
			Collections.sort(hm.get(s));
		}
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			String name = tokenizer.nextToken();
			System.out.println(hm.get(name).get(Integer.parseInt(tokenizer.nextToken()) - 1));
		}
	}
}
