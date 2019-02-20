import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class kattis_evenup {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		Stack<Integer> s = new Stack<Integer>();
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			int cur = Integer.parseInt(tokenizer.nextToken());
			if (s.isEmpty()) {
				s.push(cur);
			} else {
				if (cur % 2 == 1) {
					if (s.peek() % 2 == 0) {
						s.push(cur);
					} else {
						s.pop();
					}
				} else {
					if (s.peek() % 2 == 0) {
						s.pop();
					} else {
						s.push(cur);
					}
				}
			}
		}
		System.out.println(s.size());
	}
}
