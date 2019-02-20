import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_autori {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (char c : reader.readLine().toCharArray()) {
			if (c >= 'A' && c <= 'Z') {
				System.out.print(c);
			}
		}
	}
}
