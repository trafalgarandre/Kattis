import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_twostones {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int stones = Integer.parseInt(reader.readLine());
		if (stones % 2 == 1) {
			System.out.println("Alice");
		} else {
			System.out.println("Bob");
		}
	}
}
