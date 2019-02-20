import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_downtime {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int k = Integer.parseInt(tokenizer.nextToken());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(reader.readLine());
		}
		int left_most = 0;
		int right_most = 0;
		int count = 0;
		int max = 0;
		while (right_most < n) {
			while (right_most < n && a[right_most] >= a[left_most]
				&& a[right_most] < a[left_most] + 1000) {
					count++;
					right_most++;
				}
	        if ((int)Math.ceil((double)count / k ) > max) {
	        	max = (int)Math.ceil((double)count / k);
	        }
	        left_most++;
	        count--;
		}
		System.out.println(max);
	}
}
