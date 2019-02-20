import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class kattis_kutevi {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int k = Integer.parseInt(tokenizer.nextToken());
		tokenizer = new StringTokenizer(reader.readLine());
		TreeSet<Integer> ts = new TreeSet<Integer>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		boolean[] c = new boolean[360];
		for (int i = 0; i < n; i++) {
			a.add(Integer.parseInt(tokenizer.nextToken()));
			c[a.get(i)] = true;
			ts.add(a.get(i));
		}
		
		boolean hasNew = false;
		do {
			hasNew = false;
			int size = a.size();
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					int plus = (a.get(i) + a.get(j)) % 360;
					int minus = (a.get(i) + 360 - a.get(j)) % 360;
					if (!c[plus]) {
						hasNew = true;
						a.add(plus);
						c[plus] = true;
					}
					if (!c[minus]) {
						hasNew = true;
						a.add(minus);
						c[minus] = true;
					}
				}
			}
		} while (hasNew);
		tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < k; i++) {
			System.out.println(c[Integer.parseInt(tokenizer.nextToken())] ? "YES" : "NO");
		}
	}
}
