import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class kattis_grid {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		int[][] a = new int[n][m];
		int[][] b = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = reader.readLine();
			for (int j = 0; j < m; j++) {
				a[i][j] = str.charAt(j) - '0';
				b[i][j] = 0;
			}
		}
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(0, 0));
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			int up = cur.i - a[cur.i][cur.j];
			if (up >= 0) {
				if (b[up][cur.j] == 0) {
					b[up][cur.j] = b[cur.i][cur.j] + 1;
					queue.add(new Point(up, cur.j));
				}
			}
			int down = cur.i + a[cur.i][cur.j];
			if (down < n) {
				if (b[down][cur.j] == 0) {
					b[down][cur.j] = b[cur.i][cur.j] + 1;
					queue.add(new Point(down, cur.j));
				}
			}
			int left = cur.j - a[cur.i][cur.j];
			if (left >= 0) {
				if (b[cur.i][left] == 0) {
					b[cur.i][left] = b[cur.i][cur.j] + 1;
					queue.add(new Point(cur.i, left));
				}
			}
			int right = cur.j + a[cur.i][cur.j];
			if (right < m) {
				if (b[cur.i][right] == 0) {
					b[cur.i][right] = b[cur.i][cur.j] + 1;
					queue.add(new Point(cur.i, right));
				}
			}
		}
		if (b[n - 1][m - 1] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(b[n - 1][m - 1]);
		}
	}
	
	static class Point {
		int i;
		int j;
		Point(int _i, int _j) {
			i = _i;
			j = _j;
		}
	}
}
