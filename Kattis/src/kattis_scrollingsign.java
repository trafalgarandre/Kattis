import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_scrollingsign {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		for (int i = 0; i < n; i++) {	
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int k = Integer.parseInt(tokenizer.nextToken());
			int m = Integer.parseInt(tokenizer.nextToken());
			int total = k;
			String cur = reader.readLine();
			for (int j = 1; j < m; j++) {
				String next = reader.readLine();
				if (cur.equals(next)) {
					continue;
				} else {
					int h;
					for (h = 1; h < k; h++) {
						if (cur.substring(h).equals(next.substring(0, k - h))) {
							total += h;
							break;
						}
					}
					if (h == k) {
						total += k;
						cur = next;
					}
				}
			}
			System.out.println(total);
		}
	}
}
