import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_lineup {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String prev = reader.readLine();
		boolean isIncreasing = true;
		boolean isDecreasing = true;
		for (int i = 1; i < n; i++) {
			String cur = reader.readLine();
			if (isIncreasing) {
				if (cur.compareTo(prev) < 0) {
					isIncreasing = false;
				}
			}
			if (isDecreasing) {
				if (cur.compareTo(prev) > 0) {
					isDecreasing = false;
				}
			}
			prev = cur;
		}
		if (isIncreasing) {
			System.out.println("INCREASING");
		} else if (isDecreasing) {
			System.out.println("DECREASING");
		} else {
			System.out.println("NEITHER");
		}
	}
}
