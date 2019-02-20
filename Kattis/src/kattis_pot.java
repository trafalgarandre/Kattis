import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_pot {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int total = 0;
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(reader.readLine());
			int power = temp % 10;
			temp /= 10;
			int temp2 = 1;
			for (int j = 0; j < power; j++) {
				temp2 = temp2 * temp; 
			}
			total = total + temp2;
		}
		System.out.println(total);
	}
}
