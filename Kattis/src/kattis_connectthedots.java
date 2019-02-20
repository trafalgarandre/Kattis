import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class kattis_connectthedots {
	public static void main(String args[]) throws IOException {
		int row = 0;
		int col = 0;
		String s;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Point> points = new ArrayList<Point>();
		while ((s = reader.readLine()) != null) {
			if (s.length() != 0) {
				col = s.length();
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) != '.') {
						points.add(new Point(s.charAt(i), row, i));
					}
				}
				row++;
			} else {
				char[][] table = new char[row][col];
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						table[i][j] = '.';
					}
				}
				for (Point point:points) {
					table[point.row][point.col] = point.cc;
				}
				Collections.sort(points);
				for (int k = 0; k < points.size() - 1; k++) {
					Point prev = points.get(k);
					Point next = points.get(k + 1);
					// in case only 2 points
					if (points.size() > 2) {
						if (prev.col == next.col) {
							int low = Math.min(prev.row, next.row);
							int high = Math.max(prev.row, next.row);
							for (int i = low + 1; i < high; i++) {
								if (table[i][prev.col] == '.') {
									table[i][prev.col] = '|';
								} else if (table[i][prev.col] == '-'){
									table[i][prev.col] = '+'; 
								}
							}
						} else {
							int low = Math.min(prev.col,  next.col);
							int high = Math.max(prev.col, next.col);
							for (int i = low + 1; i < high; i++) {
								if (table[prev.row][i] == '.') {
									table[prev.row][i] = '-';
								} else if (table[prev.row][i] == '|'){
									table[prev.row][i] = '+'; 
								}
							}
						}
					}
				}
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						System.out.print(table[i][j]);
					}
					System.out.println();
				}
				System.out.println();
				points = new ArrayList<Point>();
				row = 0;
				col = 0;
			}
		}
		char[][] table = new char[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				table[i][j] = '.';
			}
		}
		for (Point point:points) {
			table[point.row][point.col] = point.cc;
		}
		Collections.sort(points);
		for (int k = 0; k < points.size() - 1; k++) {
			Point prev = points.get(k);
			Point next = points.get(k + 1);
			if (points.size() > 2) {
				if (prev.col == next.col) {
					int low = Math.min(prev.row, next.row);
					int high = Math.max(prev.row, next.row);
					for (int i = low + 1; i < high; i++) {
						if (table[i][prev.col] == '.') {
							table[i][prev.col] = '|';
						} else if (table[i][prev.col] == '-'){
							table[i][prev.col] = '+'; 
						}
					}
				} else {
					int low = Math.min(prev.col,  next.col);
					int high = Math.max(prev.col, next.col);
					for (int i = low + 1; i < high; i++) {
						if (table[prev.row][i] == '.') {
							table[prev.row][i] = '-';
						} else if (table[prev.row][i] == '|'){
							table[prev.row][i] = '+'; 
						}
					}
				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(table[i][j]);
			}
			System.out.println();
		}
	}
	
	static class Point implements Comparable<Point> {
		int val;
		int row;
		int col;
		char cc;
		Point(char c, int _row, int _col) {
			row = _row;
			col = _col;
			cc = c;
			if (c >= 'a' && c <= 'z') {
				val = 10 + (c - 'a');
			} else if (c >= 'A' && c <= 'Z') {
				val = 100 + (c - 'A');
			} else {
				val = c - '0';
			}
		}
		
		public int compareTo(Point other) {
			return this.val - other.val;
		}
	}
}
