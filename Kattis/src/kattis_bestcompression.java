import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class kattis_bestcompression {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		BigInteger n = new BigInteger(tokenizer.nextToken());
		int b = Integer.parseInt(tokenizer.nextToken()) + 1;
		BigInteger two = new BigInteger("2");
		BigInteger space = two.pow(b).subtract(BigInteger.ONE);
		if (n.compareTo(space) <= 0) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}
}
