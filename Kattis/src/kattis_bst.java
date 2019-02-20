import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;


public class kattis_bst {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		Node[] a = new Node[n + 1];
		TreeSet<Integer> ts = new TreeSet<Integer>();
		long count = 0;
		Node root = new Node(Integer.parseInt(reader.readLine()));
		root.rank = 0;
		ts.add(root.val);
		a[root.val] = root;
		System.out.println(count);
		for (int i = 1; i < n; i++) {
			int cur = Integer.parseInt(reader.readLine());
			ts.add(cur);
			Integer low = ts.lower(cur);
			Integer high = ts.higher(cur);
			Node temp = new Node(cur);
			a[cur] = temp;
			if (high == null) {
				a[low].right = temp;
				temp.rank = a[low].rank + 1;
			} else if (low == null) {
				a[high].left = temp;
				temp.rank = a[high].rank + 1;
			} else if (a[high].rank > a[low].rank) {
				a[high].left = temp;
				temp.rank = a[high].rank + 1;
			} else if (a[high].rank < a[low].rank) {
				a[low].right = temp;
				temp.rank = a[low].rank + 1;
			}
			count += temp.rank;
			System.out.println(count);
		}
	}
	
	static class Node {
		Node left = null, right = null;
		int val;
		int rank;
		Node (int _val) {
			val = _val;
		}
	}
}
