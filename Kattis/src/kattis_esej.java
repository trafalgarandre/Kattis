import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;


public class kattis_esej {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int a = Integer.parseInt(tokenizer.nextToken());
		int b = Integer.parseInt(tokenizer.nextToken());
		HashSet<String> hs = new HashSet<String>();
		int count = 0;
		while (count < b / 2) {
			String s = randomString();
			while (hs.contains(s)) {
				s = randomString();
			}
			hs.add(s);
			System.out.print(s + " ");
			count++;
		}
		while (count < a) {
			System.out.print(randomString() + " ");
			count++;
		}
	}
	
	static String randomString() {
		Random random = new Random();
		int length = random.nextInt(15) + 1;
		char[] c = new char[length];
		for (int i = 0; i < length; i++) {
			c[i] = (char)(random.nextInt(26) + 'a');
		}
		return new String(c);
	}
}
