import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_sodasurpler {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int e = Integer.parseInt(tokenizer.nextToken());
		int f = Integer.parseInt(tokenizer.nextToken());
		int c = Integer.parseInt(tokenizer.nextToken());
		int count = 0;
		e += f;
		while (e >= c) {
			count++;
			e-=c;
			e++;
		}
		System.out.println(count);
	}
}
