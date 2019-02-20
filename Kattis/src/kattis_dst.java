	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;
	
	
	public class kattis_dst {
		public static void main(String args[]) throws NumberFormatException, IOException {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(reader.readLine());
			for (int i = 0; i < n; i++) {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				boolean roll = false;
				if (tokenizer.nextToken().equals("F")) {
					roll = true;
				} else {
					roll = false;
				}
				int d = Integer.parseInt(tokenizer.nextToken());
				int h = Integer.parseInt(tokenizer.nextToken());
				int m = Integer.parseInt(tokenizer.nextToken());
				int time = h * 60 + m;
				if (roll) {
					time = (time + d) % 1440;
				} else {
					time = (time + 1440 - d) % 1440;
				}
				h = time / 60;
				m = time % 60;
				System.out.println(h + " " + m);
			}
		}
	}
