import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_vote {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(reader.readLine());
			int min_pos = -1;
			int max = 0;
			int total = 0;
			for (int j = 0; j < n; j++) {
				int temp = Integer.parseInt(reader.readLine());
				total += temp;
				if (temp > max) {
					min_pos = j;
					max = temp;
				} else if (temp == max) {
					min_pos = -1;
				}
			}
			if (min_pos == -1) {
				System.out.println("no winner");
			} else if (max > total / 2) {
				System.out.println("majority winner " + (min_pos + 1));
			} else {
				System.out.println("minority winner " + (min_pos + 1));
			}
		}
	}
}
