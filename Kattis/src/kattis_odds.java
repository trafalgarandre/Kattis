import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_odds {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		char a1 = tokenizer.nextToken().charAt(0);
		char b1 = tokenizer.nextToken().charAt(0);
		char a2 = tokenizer.nextToken().charAt(0);
		char b2 = tokenizer.nextToken().charAt(0);
		int[][][][] a = new int[7][7][7][7];
		int[][][][] b = new int[7][7][7][7];
		for (int c1 = 1; c1 < 7; c1++) {
			for (int d1 = 1; d1 < 7; d1++) {
				for (int c2 = 1; c2 < 7; c2++) {
					for (int d2 = 1; d2 < 7; d2++) {
						if (larger(c1, d1, c2, d2)) {
							a[c1][d1][c2][d2] = 1;
							a[0][d1][c2][d2]++;
							a[c1][0][c2][d2]++;
							a[c1][d1][0][d2]++;
							a[c1][d1][c2][0]++;
							a[0][0][c2][d2]++;
							a[0][d1][0][d2]++;
							a[0][d1][c2][0]++;
							a[c1][0][0][d2]++;
							a[c1][0][c2][0]++;
							a[c1][d1][0][0]++;
							a[0][0][0][d2]++;
							a[0][0][c2][0]++;
							a[0][d1][0][0]++;
							a[c1][0][0][0]++;
							a[0][0][0][0]++;
						}
						b[c1][d1][c2][d2] = 1;
						b[0][d1][c2][d2]++;
						b[c1][0][c2][d2]++;
						b[c1][d1][0][d2]++;
						b[c1][d1][c2][0]++;
						b[0][0][c2][d2]++;
						b[0][d1][0][d2]++;
						b[0][d1][c2][0]++;
						b[c1][0][0][d2]++;
						b[c1][0][c2][0]++;
						b[c1][d1][0][0]++;
						b[0][0][0][d2]++;
						b[0][0][c2][0]++;
						b[0][d1][0][0]++;
						b[c1][0][0][0]++;
						b[0][0][0][0]++;
					}
				}
			}
		}
			
				
		
		while (a1 != '0' || b1 != '0' || a2 != '0' || b2 != '0') {
			int temp1, temp2, temp3, temp4;
			if (a1 == '*') {
				temp1 = 0;
			} else {
				temp1 = a1 - '0';
			}
			if (b1 == '*') {
				temp2 = 0;
			} else {
				temp2 = b1 - '0';
			}
			if (a2 == '*') {
				temp3 = 0;
			} else {
				temp3 = a2 - '0';
			}
			if (b2 == '*') {
				temp4 = 0;
			} else {
				temp4 = b2 - '0';
			}
			int nom = a[temp1][temp2][temp3][temp4];
			int dem = b[temp1][temp2][temp3][temp4];
			int gcd = gcd(nom, dem);
			if (dem / gcd == 1 || nom / gcd == 0) {
				System.out.println(nom / gcd);
			} else {
				System.out.println((nom / gcd) + "/" + (dem / gcd));
			}
			tokenizer = new StringTokenizer(reader.readLine());
			a1 = tokenizer.nextToken().charAt(0);
			b1 = tokenizer.nextToken().charAt(0);
			a2 = tokenizer.nextToken().charAt(0);
			b2 = tokenizer.nextToken().charAt(0);
		}
	}
	
	static boolean larger(int a1, int b1, int a2, int b2) {
		int point1 = 0;
		if (a1 * b1 == 2) {
			point1 = 110;
		} else if (a1 == b1) {
			point1 = 100 + a1;
		} else {
			point1 = Math.max(a1, b1) * 10 + Math.min(a1, b1);
		}
		int point2 = 0;
		if (a2 * b2 == 2) {
			point2 = 110;
		} else if (a2 == b2) {
			point2 = 100 + a2;
		} else {
			point2 = Math.max(a2, b2) * 10 + Math.min(a2, b2);
		}
		if (point1 > point2) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }
}
