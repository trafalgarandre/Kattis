import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_10kindsofpeople {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		int[][] arr = new int[n][m];
		DisjointUnionSets set = new DisjointUnionSets(n * m);
		set.makeSet();
		for (int i = 0; i < n; i++) {
			String s = reader.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j) - '0';
				if (i > 0) {
					if (arr[i][j] == arr[i - 1][j]) {
						set.union(m * i + j, m * (i - 1) + j);
					}
				}
				if (j > 0) {
					if (arr[i][j] == arr[i][j - 1]) {
						set.union(m * i + j, m * i + j - 1);
					}
				}
			}
		}
		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int[] temp = new int[4];
			for (int j = 0; j < 4; j++) {
				temp[j] = Integer.parseInt(tokenizer.nextToken()) - 1;
			}
			int temp1 = set.find(temp[0] * m + temp[1]);
			int temp2 = set.find(temp[2] * m + temp[3]);
			if (temp1 == temp2) {
				if (arr[temp[0]][temp[1]] == 0) {
					System.out.println("binary");
				} else {
					System.out.println("decimal");
				}
			} else {
				System.out.println("neither");
			}
		}
		
	}
	
	static class DisjointUnionSets {
		int[] rank, parent;
		int n;
		
		public DisjointUnionSets(int n) {
			rank = new int[n];
			parent = new int[n];
			this.n = n;
			makeSet();
		}
		
		void makeSet() {
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
		}
		
		int find(int x) {
			if (parent[x] != x) {
				parent[x] = find(parent[x]);
			}
			return parent[x];
		}
		
		void union(int x, int y) {
			int xRoot = find(x), yRoot = find(y);
			if (xRoot == yRoot) {
				return;
			}
			
			if (rank[xRoot] < rank[yRoot]) {
				parent[xRoot] = yRoot;
			} else if (rank[yRoot] < rank[xRoot]) {
				parent[yRoot] = xRoot;
			} else {
				parent[yRoot] = xRoot;
				rank[xRoot] = rank[xRoot] + 1;
			}
		}
	}
}
