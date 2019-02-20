import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class kattis_simpleaddition {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BigInteger x = new BigInteger(reader.readLine());
		BigInteger y = new BigInteger(reader.readLine());
		System.out.println((x.add(y)));
	}
}
