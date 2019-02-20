import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class kattis_whichbase {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			System.out.print(Integer.parseInt(tokenizer.nextToken()));
			int a = Integer.parseInt(tokenizer.nextToken());
			int temp = a;
			int temp2 = 0;
			int multiply = 1;
			while (temp != 0) {
				int temp3 = temp % 10;
				if (temp3 >= 8) {
					temp2 = 0;
					break;
				} else {
					temp2 = temp2 + multiply * temp3;
					multiply *= 8;
					temp /= 10;
				}
			}
			System.out.print(" " + temp2 + " " + a);
			
			temp = a;
			temp2 = 0;
			multiply = 1;
			while (temp != 0) {
				int temp3 = temp % 10;
				temp2 = temp2 + multiply * temp3;
				multiply *= 16;
				temp /= 10;
			}
			System.out.println(" " + temp2);
		}
	}
}
