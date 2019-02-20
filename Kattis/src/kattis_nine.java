import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class kattis_nine {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		BigInteger mod = BigInteger.valueOf(1000000007);
		for (int i = 0; i < t; i++) {
			BigInteger d = BigInteger.valueOf(Long.parseLong(reader.readLine()) - 1);
			BigInteger result = BigInteger.valueOf(8).multiply(BigInteger.valueOf(9).modPow(d, mod)).mod(mod);
			System.out.println(result.toString());
		}
//		long[] a = new long[100001];
//		a[0] = 1;
//		long mod = 1000000007;
//		for (int i = 1; i < 100001; i++) {
//			a[i] = (a[i - 1] * 9) % mod;
//		}
//		int t = Integer.parseInt(reader.readLine());
//		for (int i = 0; i < t; i++) {
//			long d = Long.parseLong(reader.readLine());
//			d--;
//			long result;
//			if (d <= 100000) {
//				result = a[(int)d]; 
//			} else {
//				result = ((d / 100000) * a[100000] % mod
//						* a[(int)(d % 100000)]) % mod;
//						
//			}
//			result = result * 8 % mod;
//			System.out.println(result);
//		}
	}
}
