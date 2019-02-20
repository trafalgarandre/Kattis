import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class kattis_towering {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int[] a = new int[6];
		int[] a1 = new int[3];
		int[] a2 = new int[3];
		for (int i = 0; i < 6; i++) {
			a[i] = Integer.parseInt(tokenizer.nextToken());
		}
		int first = Integer.parseInt(tokenizer.nextToken());
		int second = Integer.parseInt(tokenizer.nextToken());
		Arrays.sort(a);
		for (int j = 4; j >= 1; j--) {
			for (int k = j - 1; k >= 0; k--) {
				if (a[5] + a[j] + a[k] == first) {
					a1[0] = a[5];
					a1[1] = a[j];
					a1[2] = a[k];
					int temp = 2;
					for (int i = 0; i < 6; i++) {
						if (i != 5 && i != j && i != k) {
							a2[temp] = a[i];
							temp--;
						}
					}
				} else if (a[5] + a[j] + a[k] == second){
					a2[0] = a[5];
					a2[1] = a[j];
					a2[2] = a[k];
					int temp = 2;
					for (int i = 0; i < 6; i++) {
						if (i != 5 && i != j && i != k) {
							a1[temp] = a[i];
							temp--;
						}
					}
				}
			}
		}
		System.out.println(a1[0] + " " + a1[1] + " " + a1[2]
				+ " " + a2[0] + " " + a2[1] + " " + a2[2]);
					
	}
}
