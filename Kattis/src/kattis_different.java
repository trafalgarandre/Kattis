import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class kattis_different {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while ((str = reader.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(str);
			BigInteger first = new BigInteger(tokenizer.nextToken());
			BigInteger second = new BigInteger(tokenizer.nextToken());
			System.out.println(first.subtract(second).abs());
		}
	}
}
