import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_statistics {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int count = 1;
		while ((str = reader.readLine()) != null && str.length() != 0) {
			StringTokenizer tokenizer = new StringTokenizer(str);
			int n = Integer.parseInt(tokenizer.nextToken());
			int max = -1000000;
			int min = 1000000;
			int range = 0;
			for (int i = 0; i < n; i++) {
				int cur = Integer.parseInt(tokenizer.nextToken());
				if (cur > max) {
					max = cur;
				}
				if (cur < min) {
					min = cur;
				}
			}
			range = max - min;
			System.out.println("Case " + count + ": " + min + " " + max + " " + range);
			count++;
		}
	}
}
