import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class kattis_countingstars {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		int case_num = 0;
		while ((s = reader.readLine()) != null) {
			case_num++;
			int rank = 0;
			StringTokenizer tokenizer = new StringTokenizer(s);
			int m = Integer.parseInt(tokenizer.nextToken());
			int n = Integer.parseInt(tokenizer.nextToken());
			int[][] graph = new int[m][n];
			char[][] a= new char[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					graph[i][j] = -1;
				}
			}
			for (int i = 0; i < m; i++) {
				String s2 = reader.readLine();
				for (int j = 0; j < n; j++) {
					a[i][j] = s2.charAt(j);
				}
			}
			
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (a[i][j] == '-' && graph[i][j] == -1) {
						Queue<Node> queue = new LinkedList<Node>();
						queue.add(new Node(i, j));
						graph[i][j] = rank;
						while (!queue.isEmpty()) {
							Node cur = queue.poll();
							if (cur.i > 0 && a[cur.i - 1][cur.j] == '-' && graph[cur.i - 1][cur.j] == -1) {
								graph[cur.i - 1][cur.j] = rank;
								queue.add(new Node(cur.i - 1, cur.j));
							}
							if (cur.i < m - 1 && a[cur.i + 1][cur.j] == '-' && graph[cur.i + 1][cur.j] == -1) {
								graph[cur.i + 1][cur.j] = rank;
								queue.add(new Node(cur.i + 1, cur.j));
							}
							if (cur.j > 0 && a[cur.i][cur.j - 1] == '-' && graph[cur.i][cur.j - 1] == -1) {
								graph[cur.i][cur.j - 1] = rank;
								queue.add(new Node(cur.i, cur.j - 1));
							}
							if (cur.j < n - 1 && a[cur.i][cur.j + 1] == '-' && graph[cur.i][cur.j + 1] == -1) {
								graph[cur.i][cur.j + 1] = rank;
								queue.add(new Node(cur.i, cur.j + 1));
							}
						}
						rank++;
					}
				}
			}
			System.out.println("Case " + case_num + ": " + rank);
		}
	}
	static class Node {
		int i,j;
		Node(int _i, int _j) {
			i = _i;
			j = _j;
		}
	}
}
