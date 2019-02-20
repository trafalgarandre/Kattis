import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_princesspeach {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int y = Integer.parseInt(tokenizer.nextToken());
		boolean[] a = new boolean[n];
		for (int i = 0; i < n; i++) {
			a[i] = false;
		}
		for (int i = 0; i < y; i++) {
			a[Integer.parseInt(reader.readLine())] = true;
		}
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (!a[i]) {
				count++;
				System.out.println(i);
			}
		}
		System.out.println("Mario got " + (n - count) +" of the dangerous obstacles.");
	}
}
