import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_a1paper {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		n--;
		double[] short_size = new double[n];
		double[] long_size = new double[n];
		double temp1 = -(double)5 / (double)4;
		double temp2 = -(double)3 / (double)4;
		short_size[0] = Math.pow(2, temp1);
		long_size[0] = Math.pow(2, temp2);
		for (int i = 1; i < n; i++) {
			short_size[i] = long_size[i - 1] / 2;
			long_size[i] = short_size[i - 1];
		}
		
		int[] pages = new int[n];
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			pages[i] = Integer.parseInt(tokenizer.nextToken());
		}
		int need = 2;
		int i = 0;
		double total = 0;
		while (need > 0 && i < n) {
			total = total + need / 2 * long_size[i];
			int left = need - pages[i];
			if (left <= 0) {
				need = 0;
			} else {
				need = left * 2;
			}
			i++;
		}
		if (need != 0) {
			System.out.println("impossible");
		} else {
			System.out.printf("%.11f", total);
		}
	}
}
