import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_playfair {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] check = new boolean[27];
		myChar[] b = new myChar[27];
		for (int i = 0; i < 27; i++) {
			check[i] = false;
		}
		check['q' - 'a'] = true;
		int row = 0;
		int col = 0;
		char[][] a = new char[5][5];
		
		for (char c: reader.readLine().toCharArray()) {
			if (c == ' ' || check[c - 'a']) {
				continue;
			} else {
				check[c - 'a'] = true;
				a[row][col] = c;
				b[c - 'a'] = new myChar(row, col);
				col++;
				if (col == 5) {
					row++;
					col = 0;
				}
			}
		}
		for (int i = 0; i < 26; i++) {
			if (!check[i]) {
				a[row][col] = (char)(i + 'a');
				b[i] = new myChar(row, col);
				col++;
				if (col == 5) {
					row++;
					col = 0;
				}
			}
		}
		
		String encryp = reader.readLine();
		encryp = encryp.replaceAll("\\s+","");
		for (int i = 0; i < encryp.length(); i +=2) {
			char c1 = encryp.charAt(i);
			char c2;
			if (i < encryp.length() - 1) {
				c2 = encryp.charAt(i + 1);
			} else {
				c2 = c1;
			}
			if (c1 == c2) {
				c2 = 'x';
				i--;
			}
			int row1 = b[c1 - 'a'].row;
			int col1 = b[c1 - 'a'].col;
			int row2 = b[c2 - 'a'].row;
			int col2 = b[c2 - 'a'].col;
			
			if (row1 == row2) {
				System.out.print((char)(a[row1][(col1 + 1) % 5] - 'a' + 'A'));
				System.out.print((char)(a[row2][(col2 + 1) % 5] - 'a' + 'A'));;
			} else if (col1 == col2) {
				System.out.print((char)(a[(row1 + 1) % 5][col1] - 'a' + 'A'));
				System.out.print((char)(a[(row2 + 1) % 5][col2] - 'a' + 'A'));
			} else {
				System.out.print((char)(a[row1][col2] - 'a' + 'A'));
				System.out.print((char)(a[row2][col1] - 'a' + 'A'));
			}
		}
	}
	
	static class myChar {
		int row, col;
		
		myChar(int _row, int _col) {
			row = _row;
			col = _col;
		}
	}
}
