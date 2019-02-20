import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_harshadnumbers {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int temp = n;
		int total = 0;
		while (temp != 0) {
			total = total + (temp % 10);
			temp /= 10;
		}
		while (n % total != 0) {
			n++;
			temp = n;
			while (temp % 10 == 0 && temp != 0) {
				total -= 9;
				temp /= 10;
			}
			total++;
		}
		System.out.println(n);
	}
}
