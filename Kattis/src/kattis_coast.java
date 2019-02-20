import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class kattis_coast {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		boolean[][] a = new boolean[n][m];
		boolean[][] b = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			char[] c = reader.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (c[j] == '0') {
					a[i][j] = true;
				} else {
					a[i][j] = false;
				}
			}
		}
		int total = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!b[i][j]) {
					b[i][j] = true;
					Queue<Node> nodes = new LinkedList<Node>();
					nodes.add(new Node(i, j));
					int temp = 0;
					boolean touch = false;
					
					while (!nodes.isEmpty()) {
						Node cur = nodes.poll();
						if (cur.i > 0) {
							if (a[cur.i - 1][cur.j] != a[cur.i][cur.j]) {
								temp++;
							} else if (!b[cur.i - 1][cur.j]) {
								b[cur.i - 1][cur.j] = true;
								nodes.add(new Node(cur.i - 1, cur.j));
							}
						}
						if (cur.i == 0) {
							if (a[cur.i][cur.j]) {
								touch = true;
							} else {
								temp++;
							}
						}
						if (cur.i == n - 1) {
							if (a[cur.i][cur.j]) {
								touch = true;
							} else {
								temp++;
							}
						}
						if (cur.i < n - 1) {
							if (a[cur.i + 1][cur.j] != a[cur.i][cur.j]) {
								temp++;
							} else if (!b[cur.i + 1][cur.j]) {
								b[cur.i + 1][cur.j] = true;
								nodes.add(new Node(cur.i + 1, cur.j));
							}
						}
						
						if (cur.j > 0) {
							if (a[cur.i][cur.j - 1] != a[cur.i][cur.j]) {
								temp++;
							} else if (!b[cur.i][cur.j - 1]) {
								b[cur.i][cur.j - 1] = true;
								nodes.add(new Node(cur.i, cur.j - 1));
							}
						}
						if (cur.j == 0) {
							if (a[cur.i][cur.j]) {
								touch = true;
							} else {
								temp++;
							}
						}
						if (cur.j == m - 1) {
							if (a[cur.i][cur.j]) {
								touch = true;
							} else {
								temp++;
							}
						}
						if (cur.j < m - 1) {
							if (a[cur.i][cur.j + 1] != a[cur.i][cur.j]) {
								temp++;
							} else if (!b[cur.i][cur.j + 1]) {
								b[cur.i][cur.j + 1] = true;
								nodes.add(new Node(cur.i, cur.j + 1));
							}
						}
					}
					if (a[i][j] && !touch) {
						total -= temp;
					}
					if (!a[i][j]) {
						total += temp;
					}
				}
			}
		}
		System.out.println(total);
	}
	
	static class Node {
		int i, j;
		
		Node(int _i, int _j) {
			i = _i;
			j = _j;
		}
	}
}
