import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_slatkisi {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		double c = Double.parseDouble(tokenizer.nextToken());
		int k = Integer.parseInt(tokenizer.nextToken());
		int temp = k;
		while (temp > 0) {
			c /= 10;
			temp--;
		}
		c = Math.round(c);
		temp = k;
		while (temp > 0) {
			c *= 10;
			temp--;
		}
		System.out.println((int)c);
	}
}
