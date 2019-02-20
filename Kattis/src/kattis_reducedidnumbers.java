import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_reducedidnumbers {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int g = Integer.parseInt(reader.readLine());
		int[] a = new int[g];
		for (int i = 0; i < g; i++) {
			a[i] = Integer.parseInt(reader.readLine());
		}
		int temp = g;
		while (temp <= 999999) {
			int count = 0;
			boolean[] check = new boolean[temp];
			for (int i = 0; i < g; i++) {
				int mod = a[i] % temp;
				if (!check[mod]) {
					count++;
					check[mod] = true;
				}
			}
			if (count == g) {
				System.out.println(temp);
				break;
			}
			temp++;
		}
	}
}
