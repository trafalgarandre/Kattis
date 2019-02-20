import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_aaah {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String say = reader.readLine();
		String hear = reader.readLine();
		if (say.length() < hear.length()) {
			System.out.println("no");
		} else {
			System.out.println("go");
		}
	}
}
