import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class kattis_abandonedanimal {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int k = Integer.parseInt(reader.readLine());
		ArrayList<ArrayList<String>> item = new ArrayList<ArrayList<String>>(n);
		for (int i = 0; i < n; i++) {
			item.add(new ArrayList<String>());
		}
		StringTokenizer tokenizer;
		for (int i = 0; i < k; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			item.get(Integer.parseInt(tokenizer.nextToken())).add(tokenizer.nextToken());
		}
		
		for (int i = 0; i < n; i++) {
			Collections.sort(item.get(i));
		}
		
		int m = Integer.parseInt(reader.readLine());
		ArrayList<String> bought = new ArrayList<String>(m);
		for (int i = 0; i < m; i++) {
			bought.add(reader.readLine());
		}
		
		LinkedList<Integer> front = new LinkedList<Integer>();
		int i = 0;
		int j = 0;
		while (i < n && j < m) {
			ArrayList<String> cur_items = item.get(i);
			if (Collections.binarySearch(cur_items, bought.get(j)) < 0) {
				i++;
			} else {
				front.add(i);
				j++;
			}
		}
		LinkedList<Integer> back = new LinkedList<Integer>();
		i = n - 1;
		j = m - 1;
		while (i >= 0 && j >= 0) {
			ArrayList<String> cur_items = item.get(i);
			if (Collections.binarySearch(cur_items, bought.get(j)) < 0) {
				i--;
			} else {
				back.addFirst(i);
				j--;
			}
		}
		if (front.size() != m) {
			System.out.println("impossible");
		} else {
			boolean check = true;
			for (int l = 0; l < m; l++) {
				if (front.pop() != back.pop()) {
					check = false;
				}
			}
			if (m == 0) {
				check = false;
			}
			if (check) {
				System.out.println("unique");
			} else {
				System.out.println("ambiguous");
			}
		}
	}
}
