import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class permutation {
	static int[] arr = new int[10];
	static int[] cur = new int[10];
	static int[] b = new int[10];
	static int n;
	static int val_n;
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			b[i] = 0;
		}
		val_n = 1;
		arr[0] = Integer.parseInt(tokenizer.nextToken());
		b[0]++;
		for (int i = 1; i < n; i++) {
			int temp = Integer.parseInt(tokenizer.nextToken());
			if (temp != arr[val_n - 1]) {
				arr[val_n] = temp;
				b[val_n]++;
				val_n++;
			} else {
				b[val_n - 1]++;
			}
		}
		permute(0);
	}
	
	static void print() {
		for (int i = 0; i < n; i++) {
			System.out.print(cur[i] + " ");
		}
		System.out.println();
	}
	
	static void permute(int pos) {
		if (pos == n) {
			print();
		} else {
			for (int i = 0; i < val_n; i++) {
				if (b[i] != 0) {
					b[i]--;
					cur[pos] = arr[i];
					permute(pos + 1);
					b[i]++;
				}
			}
		}
	}
	
}
