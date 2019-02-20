import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_rationalsequence3 {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			System.out.print(Integer.parseInt(tokenizer.nextToken()) + " ");
			tokenizer = new StringTokenizer(tokenizer.nextToken());
			int k = Integer.parseInt(tokenizer.nextToken());
			String s = new String();
			int p = 1;
			int q = 1;
			while (k != 1) {
				if (k % 2 == 0) {
					s = s.concat("0");
				} else {
					s = s.concat("1");
				}
				k /= 2;
			}
			for (int j = s.length() - 1; j >= 0; j--) {
				if (s.charAt(j) == '0') {
					q = p + q;
				} else {
					p = p + q;
				}
			}
			System.out.println(p + "/" + q);
		}		
	}
}
