import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_tarifa {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(reader.readLine());
		int n = Integer.parseInt(reader.readLine());
		int total = x * (n + 1);
		for (int i = 0; i < n; i++) {
			total -= Integer.parseInt(reader.readLine());
		}
		System.out.println(total);
	}
}
