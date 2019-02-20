import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class kattis_basicremains {
	static ArrayList<String> multi;
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n;
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		while ((n = Integer.parseInt(tokenizer.nextToken())) != 0) {
			String p = tokenizer.nextToken();
			String m = tokenizer.nextToken();
			prepareMulti(m, n);
			System.out.println(mod(p, m, n));
			tokenizer = new StringTokenizer(reader.readLine());
		}
	}
	
	static public void prepareMulti(String b, int base) {
		multi = new ArrayList<String>();
		String cur = "0";
		for (int i = 0; i <= base; i++) {
			multi.add(cur);
			cur = plus(cur, b, base);
		}
		multi.add(cur);
	}
	
	static public String mod(String a, String b, int base) {
		int t = 0;
		String cur = new String();
		while (t < a.length() || compare(cur, b) >= 0) {
			if (compare(cur, b) < 0) {
				if (cur.length() != 0 || a.charAt(t) != '0') {
					cur = cur + a.charAt(t);	
				}
				t++;
			} else {
				int temp = 2;
				while (compare(cur, multi.get(temp)) > 0) {
					temp++;
				}
				temp--;
				cur = minus(cur, multi.get(temp), base);
			}
		}
		if (cur.length() == 0) {
			return "0";
		} else {
			return cur;
		}
	}
	
	static public int compare(String a, String b) {
		while (a.length() < b.length()) {
			a = "0" + a;
		}
		while (b.length() < a.length()) {
			b = "0" + b;
		}
		return a.compareTo(b);
	}
	
	static public String plus(String a, String b, int base) {
		while (a.length() < b.length()) {
			a = "0" + a;
		}
		while (b.length() < a.length()) {
			b = "0" + b;
		}
		
		char[] cresult = new char[a.length()];
		int left = 0;
		for (int i = a.length() - 1; i >= 0; i--) { 
			int ca = a.charAt(i) - '0';
			int cb = b.charAt(i) - '0';
			cresult[i] = (char)((ca + cb + left) % base + '0');
			left = (ca + cb + left) / base;
		}
		String result = new String(cresult);
		if (left != 0) {
			result = "1" + result;
		}
		return result;
	}
	
	static public String minus(String a, String b, int base) {
		while (a.length() < b.length()) {
			a = "0" + a;
		}
		while (b.length() < a.length()) {
			b = "0" + b;
		}
		int left = 0;
		char[] cresult = new char[a.length()];
		for (int i = b.length() - 1; i >= 0; i--) {
			int ca = a.charAt(i) - '0';
			int cb = b.charAt(i) - '0';
			if (ca - left - cb < 0) {
				cresult[i] = (char)(ca + base - left - cb + (int)'0');
				left = 1;
			} else {
				cresult[i] = (char)(ca - left - cb + '0');
				left = 0;
			}
		}
		String result = new String(cresult);
		int j = 0;
		while (j < result.length() && result.charAt(j) == '0') {
			j++;
		}
		result = result.substring(j, result.length());
		return result;
	}
}
