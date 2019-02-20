import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class kattis_guessthedatastructure {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = reader.readLine()) != null) {
			int n = Integer.parseInt(s);
			Stack<Integer> stack = new Stack<Integer>();
			Queue<Integer> queue = new LinkedList<Integer>();
			PriorityQueue<Integer> priority_queue = new PriorityQueue<Integer>(Collections.reverseOrder());
			int count = 3;
			boolean isStack = true;
			boolean isQueue = true;
			boolean isPriorityQueue = true;
			for (int i = 0; i < n; i++) {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				int type = Integer.parseInt(tokenizer.nextToken());
				int temp = Integer.parseInt(tokenizer.nextToken());
				if (type == 1) {
					stack.add(temp);
					queue.add(temp);
					priority_queue.add(temp);
				} else {
					if (stack.empty() || stack.pop() != temp) {
						if (isStack) {
							isStack = false;
							count--;
						}
					}
					if (queue.isEmpty() || queue.poll() != temp) {
						if (isQueue) {
							isQueue = false;
							count--;
						}
					}
					if (priority_queue.isEmpty() || priority_queue.poll() != temp) {
						if (isPriorityQueue) {
							isPriorityQueue = false;
							count--;
						}
					}
				}
			}
			if (count == 0) {
				System.out.println("impossible");
			} else if (count > 1) {
				System.out.println("not sure");
			} else if (isStack) {
				System.out.println("stack");
			} else if (isQueue) {
				System.out.println("queue");
			} else {
				System.out.println("priority queue");
			}
		}
	}
}
