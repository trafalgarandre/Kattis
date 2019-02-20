import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_bitbybit {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n;
		while ((n = Integer.parseInt(reader.readLine())) != 0) {
			int[] a = new int[32];
			for (int j = 0; j < 32; j++) {
				a[j] = 2;
			}
			for (int i = 0; i < n; i++) {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				String instruc = tokenizer.nextToken();
				int pos = Integer.parseInt(tokenizer.nextToken());
				if (instruc.equals("CLEAR")) {
					a[31 - pos] = 0;
				} else if (instruc.equals("SET")) {
					a[31 - pos] = 1;
				} else if (instruc.equals("OR")) {
					int next = Integer.parseInt(tokenizer.nextToken());
					if (a[31 - pos] == 1 || a[31 - next] == 1) {
						a[31 - pos] = 1;
					} else  if (a[31 - pos] == 0 && a[31 - next] == 0){
						a[31 - pos] = 0;
					} else {
						a[31 - pos] = 2;
					}
				} else {
					int next = Integer.parseInt(tokenizer.nextToken());
					if (a[31 - pos] == 0 || a[31 - next] == 0) {
						a[31 - pos] = 0;
					} else if (a[31 - pos] == 1 && a[31 - next] == 1){
						a[31 - pos] = 1;
					} else {
						a[31 - pos] = 2;
					}
				}
			}
			for (int i = 0; i < 32; i++) {
				if (a[i] == 2) {
					System.out.print("?");
				} else {
					System.out.print(Integer.toString(a[i]));
				}
			}
			System.out.println();
		}
	}
}
