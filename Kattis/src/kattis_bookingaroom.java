import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_bookingaroom {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int r = Integer.parseInt(tokenizer.nextToken());
		int n = Integer.parseInt(tokenizer.nextToken());
		boolean[] check = new boolean[r];
		for (int i = 0; i < r; i++) {
			check[i] = false;
		}
		for (int i = 0; i < n; i++) {
			check[Integer.parseInt(reader.readLine()) - 1] = true;
		}
		boolean free = false;
		for (int i = 0; i < r; i++) {
			if (!check[i]) {
				System.out.println(i + 1);
				free = true;
				break;
			}
		}
		if (!free) {
			System.out.println("too late");
		}
	}
}
