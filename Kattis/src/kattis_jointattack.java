import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_jointattack {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(tokenizer.nextToken());
		}
		long num = arr[n - 1];
		long den = 1;
		for (int i = n - 2; i >= 0; i--) {
			long temp = num;
			num = den;
			den = temp;
			num = arr[i] * den + num;
			long gcd = findGCD(den, num);
			den /= gcd;
			num /= gcd;
		}
		System.out.println(num + "/" + den);
	}
	
	private static long findGCD(long a, long b) {
		if (b == 0) {
			return a;
		}
		return findGCD(b, a % b);
	}
}
