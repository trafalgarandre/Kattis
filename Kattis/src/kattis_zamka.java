import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_zamka {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int d = Integer.parseInt(reader.readLine());
		int x = Integer.parseInt(reader.readLine());
		for (int i = n; i <= d; i++) {
			if (total(i) == x) {
				System.out.println(i);
				break;
			}
		}
		for (int i = d; i >= n; i--) {
			if (total(i) == x) {
				System.out.println(i);
				break;
			}
		}
	}
	static int total(int x) {
		int total = 0;
		while (x != 0) {
			total = total + x % 10;
			x /= 10;
		}
		return total;
	}
}
