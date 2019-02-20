import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class kattis_polish {
	static ArrayList<String> str;
	static int pos;
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		int i = 0;
		while ((s = reader.readLine()) != null) {
			i++;
			str = new ArrayList<String>();
			StringTokenizer tokenizer = new StringTokenizer(s);
			while (tokenizer.hasMoreTokens()) {
				str.add(tokenizer.nextToken());
			}
			pos = -1;
			Node nodes = construct();
			System.out.println("Case " + i + ": " + solve(nodes));
		}
	}
	
	static public Node construct() {
		pos++;
		String cur = str.get(pos);
		if (cur.equals("+") || cur.equals("-") || cur.equals("*")) {
			Node me = new Node(cur);
			me.left = construct();
			me.right = construct();
			return me;
		} else {
			return new Node(cur);
		}
	}
	
	static public String solve(Node start) {
		if (start.s.equals("+") || start.s.equals("-") || start.s.equals("*")) {
			String left = solve(start.left);
			String right = solve(start.right);
			boolean reduce = true;
			String result = start.s;
			result = result + " " + left + " " + right;
			for (int i = 0 ; i < left.length(); i++) {
				if (left.charAt(i) != '-' && (left.charAt(i) < '0' || left.charAt(i) > '9')) {
					reduce = false;
					break;
				}
			}
			
			for (int i = 0 ; i < right.length(); i++) {
				if (right.charAt(i) != '-' && (right.charAt(i) < '0' || right.charAt(i) > '9')) {
					reduce = false;
					break;
				}
			}
			
			if (reduce) {
				long temp;
				if (start.s.equals("+")) {
					temp = Long.parseLong(left) + Long.parseLong(right);
				} else if (start.s.equals("-")) {
					temp = Long.parseLong(left) - Long.parseLong(right);
				} else {
					temp = Long.parseLong(left) * Long.parseLong(right);
				}
				result = Long.toString(temp);
			}
			return result;
		} else {
			return start.s;
		}
	}
	
	static class Node {
		Node left;
		Node right;
		String s;
		Node(String _s) {
			s = _s;
			left = null;
			right = null;
		}
	}
}
