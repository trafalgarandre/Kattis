import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_trainsorting {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] a = new int[n];
		int[] heavy = new int[n];
		int[] light = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(reader.readLine());
			heavy[i] = 0;
			light[i] = 0;
		}
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if (a[j] > a[i]) {
					//heavy[i]++;
					int temp = heavy[j] + 1;
					if (heavy[i] < temp) {
						heavy[i] = temp;
					}
				}
				if (a[j] < a[i]) {
					//light[i]++;
					int temp = light[j] + 1;
					if (light[i] < temp) {
						light[i] = temp;
					}
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (max < heavy[i] + light[i] + 1) {
				max = heavy[i] + light[i] + 1;
			}
		}
		System.out.println(max);
	}
}
