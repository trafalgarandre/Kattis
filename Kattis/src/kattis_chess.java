import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_chess {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		for (int k = 0; k < n; k++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int l1 = tokenizer.nextToken().charAt(0) - 'A';
			int i1 = Integer.parseInt(tokenizer.nextToken()) - 1;
			int l2 = tokenizer.nextToken().charAt(0) - 'A';
			int i2 = Integer.parseInt(tokenizer.nextToken()) - 1;
			if ((l1 % 2 + l2 % 2) % 2 != (i1 % 2 + i2 % 2) % 2) {
				System.out.println("Impossible");
			} else {
				if (l1 == l2 && i1 == i2) {
					System.out.println("0 " + (char)(l1 + 'A') + " " + (i1+ 1));
				} else if (Math.abs(l1 - l2) == Math.abs(i1 - i2)) {
					System.out.println("1 " + (char)(l1 + 'A') + " " + (i1 + 1) + " " + (char)(l2 + 'A') + " " + (i2 + 1));
				} else{
					boolean check = false;
					for (int i = 0; i < 8; i++) {
						if (check) {
							break;
						}
						for (int j = 0; j < 8; j++) {
							if (Math.abs(i - i1) == Math.abs(j - l1) && Math.abs(i - i2) == Math.abs(j - l2)) {
								System.out.println("2 " + (char)(l1 + 'A') + " " + (i1 + 1) + " " 
								+ (char)(j + 'A') + " " + (i + 1) + " " + (char)(l2 + 'A') + " " + (i2+ 1));
								check = true;
								break;
							}
						}
					}
				}
			}
		}
	}
}
