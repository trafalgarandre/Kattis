import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;


public class kattis_enviousexponents {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		long n = Long.parseLong(tokenizer.nextToken());
		int k = Integer.parseInt(tokenizer.nextToken());
		BitSet bitSet = new BitSet();
		bitSet.clear();
		int pos = 0;
		while (n != 0) {
			if (n % 2 == 1) {
				bitSet.set(pos);
			}
			n /= 2;
			pos++;
		}
		long result = 0;
		if (bitSet.cardinality() == k) {
			int temp = 0;
			while (temp < pos && !bitSet.get(temp)) {
				temp++;
			}
			int one = 0;
			while (temp < pos && bitSet.get(temp)) {
				temp++;
				one++;
			}
			if (temp >= pos) {
				bitSet.clear();
				bitSet.set(0, k - 1);
				long multi = 1;
				for (int i = 0; i < pos - 1; i++) {
					if (bitSet.get(i)) {
						result += multi;
					}
					multi *= 2;
				}
				multi *= 2;
				result += multi;
			} else {
				one--;
				bitSet.set(temp);
				bitSet.clear(0, temp);
				bitSet.flip(0, one);
				long multi = 1;
				for (int i = 0; i < pos; i++) {
					if (bitSet.get(i)) {
						result += multi;
					}
					multi *= 2;
				}
			}
		} else if (bitSet.cardinality() < k) {
			int temp = 0;
			int cardi = bitSet.cardinality();
			while (temp < pos && cardi < k) {
				if (!bitSet.get(temp)) {
					bitSet.set(temp);
					cardi++;
				}
				temp++;
			}
			long multi = 1;
			for (int i = 0; i < pos; i++) {
				if (bitSet.get(i)) {
					result += multi;
				}
				multi *= 2;
			}
			while (cardi < k) {
				result += multi;
				multi *= 2;
				cardi++;
			}
		} else {
			int temp = 0;
			int cardi = bitSet.cardinality();
			while (temp < pos && cardi >= k) {
				if (bitSet.get(temp)) {
					bitSet.set(temp, false);
					cardi--;
				}
				temp++;
			}
			int one = 0;
			while (temp < pos && bitSet.get(temp)) {
				temp++;
				one++;
			}
			if (temp == pos) {
				bitSet.clear();
				bitSet.set(0, k - 1);
				long multi = 1;
				for (int i = 0; i < pos; i++) {
					if (bitSet.get(i)) {
						result += multi;
					}
					multi *= 2;
				}
				result += multi;
			} else {
				bitSet.set(temp);
				bitSet.clear(0, temp);
				bitSet.flip(0, one);
				long multi = 1;
				for (int i = 0; i < pos; i++) {
					if (bitSet.get(i)) {
						result += multi;
					}
					multi *= 2;
				}
			}
		}
		System.out.println(result);
	}
}
