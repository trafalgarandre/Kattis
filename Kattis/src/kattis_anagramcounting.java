import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;


public class kattis_anagramcounting {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<BigInteger> fac = new ArrayList<BigInteger>();
		fac.add(BigInteger.ONE);
		for (int i = 1; i <= 100; i++) {
			fac.add(fac.get(i - 1).multiply(BigInteger.valueOf(i)));
		}
		int[] count = new int[53];
		String s;
		for (int i = 0; i < 53; i++) {
			count[i] = 0;
		}
		while ((s = reader.readLine()) != null) {
			for (char c: s.toCharArray()) {
				if (c >= 'a' && c <= 'z') {
					count[c - 'a']++;
				} else {
					count[c - 'A' + 26]++;
				}
			}
			BigInteger result = fac.get(s.length());
			for (int i = 0; i < 53; i++) {
				if (count[i] != 0) {
					result = result.divide(fac.get(count[i]));
					count[i] = 0;
				}
			}
			System.out.println(result.toString());
		}
	}
}
