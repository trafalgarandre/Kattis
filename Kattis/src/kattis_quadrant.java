import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_quadrant {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(reader.readLine());
		int y = Integer.parseInt(reader.readLine());
		if (x > 0 && y > 0) {
			System.out.println(1);
		} else if (x > 0 && y < 0) {
			System.out.println(4);
		} else if (x < 0 && y < 0) {
			System.out.println(3);
		} else {
			System.out.println(2);
		}
	}
}
