import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_babybites {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		boolean check = true;
		for (int i = 0; i < n; i++) {
			String s = tokenizer.nextToken();
			if (!s.equals("mumble") && Integer.parseInt(s) != (i + 1)) {
				check = false;
				break;
			}
		}
		if (check) {
			System.out.println("makes sense");
		} else {
			System.out.println("something is fishy");
		}
	}
}
