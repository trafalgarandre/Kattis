import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_compass {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n1 = Integer.parseInt(reader.readLine());
		int n2 = Integer.parseInt(reader.readLine());
		if (Math.abs(n1 - n2) == 180) {
			System.out.println(180);
		} else {
			int clockwise = (n2 + 360 - n1) % 360;
			int counterclockwise = (n1 + 360 - n2) % 360;
			if (clockwise > counterclockwise) {
				System.out.println(-counterclockwise);
			} else {
				System.out.println(clockwise);
			}
		}
	}
}
