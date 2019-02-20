import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_semafori {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int l = Integer.parseInt(tokenizer.nextToken());
		int cur = 0;
		int cur_dis = 0;
		int d = 0;
		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			d = Integer.parseInt(tokenizer.nextToken());
			cur = cur + d - cur_dis;
			cur_dis = d;
			int red = Integer.parseInt(tokenizer.nextToken());
			int green = Integer.parseInt(tokenizer.nextToken());
			if (cur % (red + green) < red) {
				cur = cur + (red - cur % (red + green));
			}
		}
		cur = cur + (l - cur_dis);
		System.out.println(cur);
	}
}
