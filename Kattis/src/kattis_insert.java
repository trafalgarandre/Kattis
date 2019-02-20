import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class kattis_insert {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = reader.readLine()) != "0") {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			Node root = new Node(Integer.parseInt(tokenizer.nextToken()));
			while (tokenizer.hasMoreTokens()) {
				int temp = Integer.parseInt(tokenizer.nextToken());
				boolean insert = false;
				Node cur = root;
				while (!insert) {
					if (temp >= cur.value) {
						if (cur.right == null) {
							cur.right = new Node(temp);
							insert = true;
						} else {
							cur = cur.right;
						}
					} else {
						if (cur.left == null) {
							cur.left = new Node(temp);
							insert = true;
						} else {
							cur = cur.left;
						}
					}
				}
			}
			Result result = execute(root);
			if (result.two.equals(BigInteger.ZERO)) {
				System.out.println(1);
			} else {
				System.out.println(result.two.toString());
			}
		}
	}
	
	static public Result execute(Node cur) {
		if (cur.left == null && cur.right == null) {
			return new Result(BigInteger.ONE, BigInteger.ZERO);
		} else if (cur.left == null) {
			return new Result(BigInteger.ONE, BigInteger.ZERO).plus(execute(cur.right));
		} else if (cur.right == null) {
			return new Result(BigInteger.ONE, BigInteger.ZERO).plus(execute(cur.left));
		} else {
			BigInteger left = execute(cur.left).sum();
			BigInteger right = execute(cur.right).sum();
			if (left.compareTo(right) < 0) {
				right = right.add(BigInteger.ONE);
			} else {
				left = left.add(BigInteger.ONE);
			}
			return new Result(BigInteger.ZERO, left.multiply(right));
		}
	}
	
	
	static class Node {
		int value;
		Node left;
		Node right;
		Node(int _value) {
			value = _value;
			left = null;
			right = null;
		}
	}
	
	static class Result {
		BigInteger one;
		BigInteger two;
		Result(BigInteger _one, BigInteger _two) {
			one = _one;
			two = _two;
		}
		
		Result plus(Result o) {
			one = one.add(o.one);
			two = two.add(o.two);
			return this;
		}
		
		BigInteger sum() {
			return one.add(two);
		}
	}
}
