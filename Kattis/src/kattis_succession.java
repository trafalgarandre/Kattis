import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class kattis_succession {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		HashMap<String, Node> hs = new HashMap<String, Node>();
		HashMap<String, Boolean> a = new HashMap<String, Boolean>();

		String name = reader.readLine();
		Node founder = new Node(null, null, name);
		founder.isFounder = true;
		founder.blood = 10000000;
		hs.put(name, founder);
		a.put(name, true);
		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			String child = tokenizer.nextToken();
			String mother = tokenizer.nextToken();
			String father = tokenizer.nextToken();
			if (!hs.containsKey(mother)) {
				hs.put(mother, new Node(null, null, mother));
				a.put(mother, false);
			}
			if (!hs.containsKey(father)) {
				hs.put(father, new Node(null, null, father));
				a.put(father, false);
			}
			if (hs.containsKey(child)) {
				Node temp = hs.get(child);
				temp.father = hs.get(father);
				temp.mother = hs.get(mother);
			} else {
				a.put(child, false);
				hs.put(child, new Node(hs.get(mother), hs.get(father), child));
			}
		}
		boolean change = true;
		while (change) {
			change = false;
			for (String s: hs.keySet()) {
				if (!a.get(s)) {
					Node temp = hs.get(s);
					double temp_blood = 0;
					boolean can = true;
					if (temp.mother != null) {
						if (a.get(temp.mother.name)) {
							temp_blood += hs.get(temp.mother.name).blood / 2;
						} else {
							can = false;
						}
					}
					if (temp.father != null) {
						if (a.get(temp.father.name)) {
							temp_blood += hs.get(temp.father.name).blood / 2;
						} else {
							can = false;
						}
					}
					if (can) {
						change = true;
						a.put(s, true);
						hs.get(s).blood = temp_blood;
					}
				}
			}
		}
		Node[] nodes = new Node[m];
		for (int i = 0; i < m; i++) {
			String temp = reader.readLine();
			if (!hs.containsKey(temp)) {
				nodes[i] = new Node(null, null, temp);
			} else {
				nodes[i] = hs.get(temp);
			}
		}
		Arrays.sort(nodes);
		System.out.println(nodes[0].name);
	}
	
	static class Node implements Comparable<Node> {
		boolean isFounder = false;
		Node mother;
		Node father;
		String name;
		double blood = 0;
		
		Node(Node _mother, Node _father, String _name) {
			mother = _mother;
			father = _father;
			name = _name;
		}

		@Override
		public int compareTo(Node o) {
			if (blood > o.blood) {
				return -1;
			} else if (blood < o.blood) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}
