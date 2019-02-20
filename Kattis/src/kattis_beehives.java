import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_beehives {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		double d = Double.parseDouble(tokenizer.nextToken());
		int n = Integer.parseInt(tokenizer.nextToken());
		double[] x = new double[n];
		double[] y = new double[n];
		for (int i = 0; i < n; i++) {
			x[i] = Double.parseDouble(tokenizer.nextToken());
			y[i] = Double.parseDouble(tokenizer.nextToken());
		}
		double[][] a = new double[n][n];
		boolean[] check = new boolean[n];
		for (int i = 0; i < n ; i++) {
			if (!check[i]) {
				for (int j = 1; j < n; j++) {
					if (!check[j]) {
						double _x = (x[i] - x[j]) * (x[i] - x[j]);
						double _y = (y[i] - y[j]) * (y[i] - y[j]);
						double distance = Math.sqrt(_x + _y);
						if (distance <= d) {
							check[i] = true;
							check[j] = true;
						}
					}  
				}
			}
		}
	}
}
