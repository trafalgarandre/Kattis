import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_exam {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(reader.readLine());
		String my = reader.readLine();
		String your = reader.readLine();
		int same = 0;
		for (int i = 0; i < my.length(); i++) {
			if (my.charAt(i) == your.charAt(i)) {
				same++;
			}
		}
		int diff = my.length() - same;
		if (k <= same) {
			System.out.println(k + diff);
		} else {
			System.out.println(same + diff - (k - same));
		}
	}
}
