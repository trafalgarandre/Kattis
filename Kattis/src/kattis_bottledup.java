import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_bottledup {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int s = Integer.parseInt(tokenizer.nextToken());
		int v1 = Integer.parseInt(tokenizer.nextToken());
		int v2 = Integer.parseInt(tokenizer.nextToken());
		int min = Integer.MAX_VALUE;
		int min_v1 = -1;
		int min_v2 = -1;
		for (int i = 0; i <= Math.ceil(s / v1); i++) {
			if ((s - v1 * i) % v2 == 0) {
				int _v2 = (s - v1 * i) / v2;
				if (i + _v2 < min) {
					min = i + _v2;
					min_v1 = i;
					min_v2 = _v2;
				}
			}
		}
		if (min_v1 == -1 && min_v2 == -1) {
			System.out.println("Impossible");
		} else {
			System.out.println(min_v1 + " " + min_v2);
		}
	}
}
