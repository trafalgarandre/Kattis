import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class kattis_iks {
	static ArrayList<Integer> prime;
	static int[] total;
	public static void main(String args[]) throws NumberFormatException, IOException {
		boolean[] c = new boolean[1000000];
		int temp = 2;
		prime = new ArrayList<Integer>();
		while (temp < 1000000) {
			if (!c[temp]) {
				prime.add(temp);
				int temp2 = 2;
				while (temp * temp2 < 1000000) {
					c[temp * temp2] = true;
					temp2++;
				}
			}
			temp++;
		}
		total = new int[prime.size()];
		for (int i = 0; i < total.length; i++) {
			total[i] = 0;
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		ArrayList<Number> numbers = new ArrayList<Number>();
		for (int i = 0; i < n; i++) {
			numbers.add(new Number(Integer.parseInt(tokenizer.nextToken())));
		}
		long result = 1;
		long result2 = 0;
		for (int i = 0; i < prime.size(); i++) {
			if (total[i] / n > 0) {
				result = result * (long)Math.pow(prime.get(i), total[i] / n);
				for (Number number: numbers) {
					if (number.count[i] < total[i] / n) {
						result2 = result2 + total[i] / n - number.count[i];
					}
				}
			}
		}
		System.out.println(result + " " + result2);
	}
	
	static class Number {
		int val;
		int[] count;
		Number(int _val) {
			val = _val;
			count = new int[prime.size()];
			for (int i = 0; i < count.length; i++) {
				count[i] = 0;
			}
			int temp = 0;
			while (_val != 1) {
				if (_val % prime.get(temp) == 0) {
					count[temp]++;
					total[temp]++;
					_val /= prime.get(temp);
				} else {
					temp++;
				}
			}
		}
	}
}
