import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class kattis_dasort {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int p = Integer.parseInt(reader.readLine());
		for (int i = 0; i < p; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			System.out.print(Integer.parseInt(tokenizer.nextToken()) + " ");
			int n = Integer.parseInt(tokenizer.nextToken());
			int[] numbers = new int[n];
			int[] primitive = new int[n];
			for (int j = 0; j < n; j++) {
				if (j % 10 == 0) {
					tokenizer = new StringTokenizer(reader.readLine());
				}
				numbers[j] = Integer.parseInt(tokenizer.nextToken());
				primitive[j] = numbers[j];
			}
			Arrays.sort(numbers);
			int k = 0;
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (numbers[k] == primitive[j]) {
					count++;
					k++;
				}
			}
			System.out.println(n - count);
		}
	}
}
