import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_secretmessage {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int base[] = new int[100];
		for (int i = 0; i < 100; i++) {
			base[i] = (i + 1) * (i + 1);
		}
		for (int i = 0; i < n; i++) {
			String s = reader.readLine();
			int temp = 0;
			while (base[temp] < s.length()) {
				temp++;
			}
			temp++;
			char[][] c = new char[temp][temp];
			int count = 0;
			for (int j = 0; j < temp; j++) {
				for (int k = 0; k < temp; k++) {
					if (count < s.length()) {
						c[j][k] = s.charAt(count);
					} else {
						c[j][k] = '*';
					}
					count++;
				}
			}
			for (int j = 0; j < temp; j++) {
				for (int k = temp - 1; k >=0 ; k--) {
					if (c[k][j] != '*') {
						System.out.print(c[k][j]);
					}
				}
			}
			System.out.println();
		}
	}
}
