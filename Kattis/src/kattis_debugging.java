import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_debugging {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int r = Integer.parseInt(tokenizer.nextToken());
		int p = Integer.parseInt(tokenizer.nextToken());
		long time = 0;
		while (n > 1) {
			int temp = 2;
			while (temp <= n && (long)p * (long)(temp - 1) <= (long)r) {
				temp++;
			}
			if (temp != 2) {
				temp--;
			}
			time = time + (long)p * (long)(temp - 1) + r;
			n = n / temp + n % temp;
		}
		System.out.println(time);
	}
}
