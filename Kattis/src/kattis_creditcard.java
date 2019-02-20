import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_creditcard {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			double R = 1 + Double.parseDouble(tokenizer.nextToken()) / 100;
			long B = (long) (Double.parseDouble(tokenizer.nextToken()) * 100);
			long M = (long) (Double.parseDouble(tokenizer.nextToken()) * 100);
			int start = 0;
			if ((long) (Math.round((R - 1) * (double)B)) >= M) {
			    System.out.println("impossible");
			    continue;
			}
			while (B > 0 && start < 1200) {
			    B = (long) (Math.round(R * (double)B));
				start++;
				B = B - M;
			}
			if (B <= 0 && start <= 1200) {
				System.out.println(start);
			} else {
				System.out.println("impossible");
			}
		}
	}
}
