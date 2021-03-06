import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class kattis_moneymatters {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		int[] a = new int[n];
		Node[] nodes = new Node[n];
		boolean[] check = new boolean[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(reader.readLine());
			nodes[i] = new Node(i);
			check[i] = false;
		}
		
		for (int i = 0; i < m; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(tokenizer.nextToken());
			int y = Integer.parseInt(tokenizer.nextToken());
			nodes[x].nodes.add(y);
			nodes[y].nodes.add(x);
		}
		boolean isPossible = true;
		int count = n;
		while (isPossible && count > 0) {
			for (int i = 0; i < n; i++) {
				if (!check[i]) {
					int weight = 0;
					Queue<Integer> q = new LinkedList<Integer>();
					check[i] = true;
					weight += a[i];
					count--;
					q.add(i);
					while (!q.isEmpty()) {
						int cur = q.poll();
						for (int id: nodes[cur].nodes) {
							if (!check[id]) {
								check[id] = true;
								q.add(id);
								weight += a[id];
								count--;
							}
						}
					}
					if (weight != 0) {
						isPossible = false;
					}
				}
			}
		}
		if (isPossible) {
			System.out.println("POSSIBLE");
		} else {
			System.out.println("IMPOSSIBLE");
		}
	}
	
	static class Node {
		ArrayList<Integer> nodes;
		int index;
		Node(int _index) {
			index = _index;
			nodes = new ArrayList<Integer>();
		}
	}
}
