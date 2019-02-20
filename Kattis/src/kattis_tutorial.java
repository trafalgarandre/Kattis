import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_tutorial {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		double m = Double.parseDouble(tokenizer.nextToken());
		double n = Double.parseDouble(tokenizer.nextToken());
		int t = Integer.parseInt(tokenizer.nextToken());
		boolean isTLE = false;
		if (t == 7) {
			if (n > m) {
				isTLE = true;
			}
		} else if (t == 6) {
			double log_n = Math.log(n) / Math.log(2);
			if (log_n * n > m) {
				isTLE = true;
			}
		} else if (t == 5) {
			if (n * n > m) {
				isTLE = true;
			}
		} else if (t == 4) {
			double count = 1;
			double n3 = n;
			while (count < 3 && n3 <= m) {
				n3 *= n;
				count++;
			}
			if (n3 > m) {
				isTLE = true;
			}
		} else if (t == 3) {
			double count = 1;
			double n4 = n;
			while (count < 4 && n4 <= m) {
				n4 *= n;
				count++;
			}
			if (n4 > m) {
				isTLE = true;
			}
		} else if (t == 2) {
			double count = 1;
			double _2n = 2;
			while (count < n && _2n <= m) {
				_2n *=2;
				count++;
			}
			if (_2n > m) {
				isTLE = true;
			}
		} else {
			double count = 1;
			double n_ = 1;
			while (count <= n && n_ <= m) {
				n_ *= count;
				count++;
			}
			if (n_ > m) {
				isTLE = true;
			}
		}
		if (isTLE) {
			System.out.println("TLE");
		} else {
			System.out.println("AC");
		}
	}
}
