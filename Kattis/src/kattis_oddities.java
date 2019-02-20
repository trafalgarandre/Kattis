import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_oddities {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(reader.readLine());
			System.out.print(temp + " is ");
			if (temp % 2 == 0) {
				System.out.println("even");
			} else {
				System.out.println("odd");
			}
		}
	}
}
