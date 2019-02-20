import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_modulo {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean[] check = new boolean[42];
		for (int i = 0; i < 10; i++) {
			int n = Integer.parseInt(reader.readLine());
			check[n % 42] = true;
		}
		int count = 0;
		for (int i = 0 ; i < 42; i++) {
			if (check[i]) {
				count++;
			}
		}
		System.out.println(count);
	}
}
