import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_justaminute {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		double m = 0;
		double sl = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			m += Integer.parseInt(tokenizer.nextToken());
			sl += Integer.parseInt(tokenizer.nextToken());
		}
		double ratio = sl / (m * 60);
		if (ratio <= 1) {
			System.out.println("measurement error");
		} else {
			System.out.println(ratio);
		}
	}
}
