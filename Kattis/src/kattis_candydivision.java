import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;


public class kattis_candydivision {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(reader.readLine());
		TreeSet<Long> ts = new TreeSet<Long>();
		//ArrayList<Long> a = new ArrayList<Long>();
		for (int i = 1; i <= Math.ceil(Math.sqrt(n)); i++) {
			if (n % i == 0) {
				ts.add((long)i - 1);
				ts.add(n / i - 1);
			}
		}
		//Collections.sort(a);
//		for (long i: a) {
//			System.out.print((i - 1) + " ");
//		}
		Iterator<Long> iter = ts.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}
}
