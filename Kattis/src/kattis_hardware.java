import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_hardware {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			System.out.println(reader.readLine());
			String s = reader.readLine();
			System.out.println(s);
			StringTokenizer tokenizer = new StringTokenizer(s);
			int n = Integer.parseInt(tokenizer.nextToken());
			int[] count = new int[10];
			int count2 = n;
			while (count2 != 0) {
				s = reader.readLine();
				if (s.charAt(0) == '+') {
					tokenizer = new StringTokenizer(s);
					tokenizer.nextToken();
					int start = Integer.parseInt(tokenizer.nextToken());
					int end = Integer.parseInt(tokenizer.nextToken());
					int interval = Integer.parseInt(tokenizer.nextToken());
					for (int j = start; j <= end; j += interval) {
						int temp = j;
						count2--;
						while (temp != 0) {
							count[temp % 10]++;
							temp /= 10;
						}
					}
				} else {
					int temp = Integer.parseInt(s);
					count2--;
					while (temp != 0) {
						count[temp % 10]++;
						temp /= 10;
					}
				}
			}
			int total = 0;
			for (int j = 0; j < 10; j++) {
				System.out.println("Make " + count[j] + " digit " + j);
				total += count[j];
			}
			System.out.print("In total " + total + " digit");
			if (total > 1) {
				System.out.print("s");
			}
			System.out.println();
		}
	}
}
