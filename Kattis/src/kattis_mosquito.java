import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_mosquito {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while ((str = reader.readLine()) != null && str.length() != 0) {
			StringTokenizer tokenizer = new StringTokenizer(str);
			int m = Integer.parseInt(tokenizer.nextToken());
			int p = Integer.parseInt(tokenizer.nextToken());
			int l = Integer.parseInt(tokenizer.nextToken());
			int e = Integer.parseInt(tokenizer.nextToken());
			int r = Integer.parseInt(tokenizer.nextToken());
			int s = Integer.parseInt(tokenizer.nextToken());
			int n = Integer.parseInt(tokenizer.nextToken());
			for (int i = 0; i < n; i++) {
				int temp_m = p / s;
				int temp_p = l / r;
				int temp_l = e * m;
				m = temp_m;
				p = temp_p;
				l = temp_l;
			}
			System.out.println(m);
		}
	}
}
