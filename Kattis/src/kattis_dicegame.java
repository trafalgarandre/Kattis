import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_dicegame {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int a1 = Integer.parseInt(tokenizer.nextToken());
		int b1 = Integer.parseInt(tokenizer.nextToken());
		int a2 = Integer.parseInt(tokenizer.nextToken());
		int b2 = Integer.parseInt(tokenizer.nextToken());
		int total1 = 0;
		int total2 = 0;
		for (int i = a1; i <= b1; i++) {
			total1 += i;
		}
		for (int i = a2; i <= b2; i++) {
			total2 += i;
		}
		double prob1 = (double)total1 / (b1 - a1 + 1) + (double)total2 / (b2 - a2 + 1);
		tokenizer = new StringTokenizer(reader.readLine());
		a1 = Integer.parseInt(tokenizer.nextToken());
		b1 = Integer.parseInt(tokenizer.nextToken());
		a2 = Integer.parseInt(tokenizer.nextToken());
		b2 = Integer.parseInt(tokenizer.nextToken());
		total1 = 0;
		total2 = 0;
		for (int i = a1; i <= b1; i++) {
			total1 += i;
		}
		for (int i = a2; i <= b2; i++) {
			total2 += i;
		}
		double prob2 = (double)total1 / (b1 - a1 + 1) + (double)total2 / (b2 - a2 + 1);
		if (prob1 == prob2) {
			System.out.println("Tie");
		} else if (prob1 < prob2) {
			System.out.println("Emma");
		} else {
			System.out.println("Gunnar");
		}
	}
}
