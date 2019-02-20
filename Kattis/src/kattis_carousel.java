import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_carousel {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		while (n != 0 && m != 0) {
			int _a = -1;
			int _b = -1;	
			for (int i = 0; i < n; i++) {
				tokenizer = new StringTokenizer(reader.readLine());
				int a = Integer.parseInt(tokenizer.nextToken());
				int b = Integer.parseInt(tokenizer.nextToken());
				if ((a <= m) && ((_a == -1 && _b == -1) || ((double)b / (double)a < (double)_b / (double) _a) 
						|| ((double)b / (double)a == (double)_b / (double)_a && a > _a))) {
					_a = a;
					_b = b;
				}
			}			
			if (_a == -1 & _b == -1) {
				System.out.println("No suitable tickets offered");
			} else {
				System.out.println("Buy " + _a +" tickets for $" + _b);
			}
			tokenizer = new StringTokenizer(reader.readLine());
			n = Integer.parseInt(tokenizer.nextToken());
			m = Integer.parseInt(tokenizer.nextToken());
		}
	}
}
