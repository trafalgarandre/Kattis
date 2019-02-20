import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.TreeSet;


public class kattis_milestones {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int m = Integer.parseInt(tokenizer.nextToken());
		int n = Integer.parseInt(tokenizer.nextToken());
		double[] a = new double[m];
		tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < m; i++) {
			a[i] = Double.parseDouble(tokenizer.nextToken());
		}
		tokenizer = new StringTokenizer(reader.readLine());
		double[] b = new double[n];
		for (int i = 0; i < n; i++) {
			b[i] = Double.parseDouble(tokenizer.nextToken());
		}
		HashSet<Double> hs = new HashSet<Double>();
		TreeSet<Long> mile = new TreeSet<Long>();
		for (int i = 0; i < n - m + 1; i++) {
			long first_distance = (long)b[i + 1] - (long)b[i];
			double distance = (b[i + 1] - b[i]) / (a[1] - a[0]);
			boolean check = true;
			for (int j = i + 1; j < i + m - 1; j++) {
				if (distance != (b[j + 1] - b[j]) / (a[j + 1 - i] - a[j - i])) {
						check = false;
						break;
				}
			}
			if (check) {
				hs.add(distance);
				mile.add(first_distance);
			}
		}
		System.out.println(hs.size());
		Iterator<Long> iter = mile.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}
}
