import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class kattis_primepath {
	static ArrayList<Prime> primes;
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		prepare();
		int n = Integer.parseInt(reader.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokenizer.nextToken());
			int b = Integer.parseInt(tokenizer.nextToken());
			for (int j = 0; j < primes.size(); j++) {
				if (a == primes.get(j).val) {
					a = j;
				}
			}
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(a);
			int[] c = new int[primes.size()];
			for (int j = 0; j < c.length; j++) {
				c[j] = -1;
			}
			c[a] = 0;
			int result = -1;
			if (primes.get(a).val == b) {
				result = 0;
			} else {
				while (!q.isEmpty()) {
					int cur = q.poll();
					for (int j: primes.get(cur).other) {
						if (c[j] == -1) {
							c[j] = c[cur] + 1;
							q.add(j);
							if (primes.get(j).val == b) {
								result = c[j];
							}
						}
					}
				}
			}
			if (result == -1) {
				System.out.println("Impossible");
			} else {
				System.out.println(result);
			}
		}
	}
	
	static void prepare() {
		primes = new ArrayList<Prime>();
		boolean[] a = new boolean[10000];
		int temp = 2;
		while (temp <= 97) {
			if (!a[temp]) {
				int temp2 = 2;
				while (temp * temp2 < 10000) {
					a[temp * temp2] = true;
					temp2++;
				}
			}
			temp++;
		}
		for (int i = 1000; i < 10000; i++) {
			if (!a[i]) {
				primes.add(new Prime(i));
			}
		}
		for (int i = 0; i < primes.size(); i++) {
			for (int j = i + 1; j < primes.size(); j++) {
				if (primes.get(i).isNeighbor(primes.get(j))) {
					primes.get(i).other.add(j);
					primes.get(j).other.add(i);
				}
			}
		}
	};
	
	static class Prime {
		int val;
		ArrayList<Integer> other;
		
		Prime(int _val) {
			val = _val;
			other = new ArrayList<Integer>();
		}
		
		boolean isNeighbor(Prime other) {
			int temp1 = val;
			int temp2 = other.val;
			int t = 0;
			while (temp1 > 0 && temp2 > 0) {
				if (temp1 % 10 != temp2 % 10) {
					t++;
				}
				temp1 /= 10;
				temp2 /= 10;
			}
			return t == 1 ? true : false;
		}
	}
}
