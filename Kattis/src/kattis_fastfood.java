import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class kattis_fastfood {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			int prize = 0;
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokenizer.nextToken());
			int m = Integer.parseInt(tokenizer.nextToken());
			ArrayList<Prize> b = new ArrayList<Prize>(n);
			for (int j = 0; j < n; j++) {
				tokenizer = new StringTokenizer(reader.readLine());
				Prize cur = new Prize();
				int k = Integer.parseInt(tokenizer.nextToken());
				for (int h = 0; h < k; h++) {
					cur.stickers.add(Integer.parseInt(tokenizer.nextToken()));
				}
				cur.cost = Integer.parseInt(tokenizer.nextToken());
				b.add(cur);
			}
			int[] check = new int[m + 1];
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < m; j++) {
				check[j + 1] = Integer.parseInt(tokenizer.nextToken());
			}
			for (int j = 0; j < n; j++) {
				Prize cur = b.get(j);
				boolean no = false;
				while (!no) {
					for (int h = 0; h < cur.stickers.size(); h++) {
						if (check[cur.stickers.get(h)] == 0) {
							no = true;
						}
					}
					if (!no) {
						prize += cur.cost;
						for (int h = 0; h < cur.stickers.size(); h++) {
							check[cur.stickers.get(h)]--;
						}
					}
				}
			}
			System.out.println(prize);
		}
	}
	
	static class Prize {
		ArrayList<Integer> stickers;
		int cost;
		Prize() {
			stickers = new ArrayList<Integer>();
		}
		
	}
}
