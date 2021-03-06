import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_listgame {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean[] check = new boolean[31623];
		for (int i = 0; i < 31623; i++) {
			check[i] = true;
		}
		for (int i = 2; i < 31623;i++) {
			if (check[i]) {
				int temp = 2;
				while (i * temp < 31623) {
					check[i * temp] = false;
					temp++;
				}
			}
		}
		long x = Integer.parseInt(reader.readLine());
		int k = 0;
		int temp = 2;
		while (x != 1 && temp < 31623) {
			if (check[temp]) {
				while (x % temp == 0) {
					x /= temp;
					k++;
				}
			}
			temp++;
		}
		if (x != 1) {
			k++;
		}
		System.out.println(k);
	}
}
