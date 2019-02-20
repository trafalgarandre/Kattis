import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class kattis_iwannabe {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int k = Integer.parseInt(tokenizer.nextToken());
		ArrayList<Point> attack = new ArrayList<Point>(n);
		ArrayList<Point> defense = new ArrayList<Point>(n);
		ArrayList<Point> health = new ArrayList<Point>(n);
		boolean[] check = new boolean[n];
		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			attack.add(new Point(Long.parseLong(tokenizer.nextToken()), i));
			defense.add(new Point(Long.parseLong(tokenizer.nextToken()), i));
			health.add(new Point(Long.parseLong(tokenizer.nextToken()), i));		
			check[i] = false;
		}
		Collections.sort(attack);
		Collections.sort(defense);
		Collections.sort(health);
		for (int i = 0; i < k; i++) {
			check[attack.get(i).pos] = true;
			check[defense.get(i).pos] = true;
			check[health.get(i).pos] = true;
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (check[i]) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	static class Point implements Comparable<Point> {
		long val;
		int pos;
		Point(long _val, int _pos) {
			val = _val;
			pos = _pos;
		}
		
		public int compareTo(Point other) {
			if (other.val - this.val < 0) {
				return -1;
			} else if (other.val == this.val) {
				return 0;
			} else {
				return 1;
			}
		}
	}
	
	
}
