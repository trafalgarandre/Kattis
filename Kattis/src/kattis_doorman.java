import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_doorman {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String s = reader.readLine();
		int diff = 0;
		int prev_val = 0;
		boolean prev = false;
		int pos = 0;
		while (pos != s.length()) {
			int cur = s.charAt(pos) == 'M' ? 1 : -1;
			if (prev) {
				if (Math.abs(diff + prev_val) <= n) {
					prev = false;
					diff += prev_val;
				} else if (Math.abs(diff + cur) <= n) {
					diff += cur;
					pos++;
				} else {
					break;
				}
			} else {
				if (Math.abs(diff + cur) <= n) {
					diff += cur;
					pos++;
				} else if (pos + 1 < s.length()){
					int temp = s.charAt(pos + 1) == 'M' ? 1 : - 1;
					if (Math.abs(diff + temp) <= n) {
						diff += temp;
						prev = true;
						prev_val = cur;
						pos += 2;
					} else {
						break;
					}
				}
			}
		}
		if (prev) {
			if (Math.abs(diff + prev_val) <= n) {
				diff += prev_val;
				prev = false;
			}
		}
		int temp = prev ? 1 : 0;
		System.out.println(pos - temp);
	}
}
