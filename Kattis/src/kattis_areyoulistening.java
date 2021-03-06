import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class kattis_areyoulistening {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int cx = Integer.parseInt(tokenizer.nextToken());
		int cy = Integer.parseInt(tokenizer.nextToken());
		int n = Integer.parseInt(tokenizer.nextToken());
		double[] distance = new double[n];
		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			double x = Integer.parseInt(tokenizer.nextToken());
			double y = Integer.parseInt(tokenizer.nextToken());
			double r = Integer.parseInt(tokenizer.nextToken());
			distance[i] = Math.sqrt((x - cx) * (x - cx)
					+ (y - cy) * (y - cy)) - r;
		}
		Arrays.sort(distance);
		if (distance[2] < 0) {
			System.out.println(0);
		} else {
			System.out.println((int)distance[2]);
		}
	}
}
