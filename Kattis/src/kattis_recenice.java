import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class kattis_recenice {
	public static void main(String args[]) throws NumberFormatException, IOException {
		HashMap<Integer, String> hs = new HashMap<Integer, String>();
		hs.put(1,  "one");
		hs.put(2, "two");
		hs.put(3, "three");
		hs.put(4, "four");
		hs.put(5, "five");
		hs.put(6, "six");
		hs.put(7, "seven");
		hs.put(8, "eight");
		hs.put(9, "nine");
		hs.put(10, "ten");
		hs.put(11, "eleven");
		hs.put(12, "twelve");
		hs.put(13, "thirteen");
		hs.put(14, "fourteen");
		hs.put(15, "fifteen");
		hs.put(16, "sixteen");
		hs.put(17, "seventeen");
		hs.put(18, "eighteen");
		hs.put(19, "nineteen");
		hs.put(20, "twenty");
		hs.put(30, "thirty");
		hs.put(40, "forty");
		hs.put(50, "fifty");
		hs.put(60, "sixty");
		hs.put(70, "seventy");
		hs.put(80, "eighty");
		hs.put(90, "ninety");
		for (int i = 1; i < 10; i++) {
			hs.put(i * 100, hs.get(i) + "hundred");
		}
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				hs.put(i * 10 + j, hs.get(i * 10) + hs.get(j));
			}
		}
		
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 100; j++) {
				hs.put(i * 100 + j, hs.get(i * 100) + hs.get(j));
			}
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] a = new String[n];
		int total = 0;
		for (int i = 0; i < n; i++) {
			String s = reader.readLine();
			if (!s.equals("$")) {
				total += s.length();
			}
			a[i] = s;
		}
		String result = null;
		for (int i = total + 1; i < 1000; i++) {
			if (i == total + hs.get(i).length()) {
				result = hs.get(i);
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			if (a[i].equals("$")) {
				System.out.print(result + " ");
			} else {
				System.out.print(a[i] + " ");
			}
		}
	}
}
