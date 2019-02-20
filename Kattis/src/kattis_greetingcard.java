import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class kattis_greetingcard {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		ArrayList<Point> _2018 = new ArrayList<Point>();
		long square2018 = 2018 * 2018;
		for (int i = 0; i <= 2018; i++) {
			long squarey = square2018 - i * i;
			long y = (long)Math.sqrt(squarey);
			if (y * y == squarey) {
				_2018.add(new Point(i, y));
				if (y != 0) {
				_2018.add(new Point(i, -y));
				}
				if (i != 0) {
				_2018.add(new Point(-i, y));
				}
				if (y != 0 && i != 0) {
					_2018.add(new Point(-i, -y));			
				}
			}
		}
		Point[] points = new Point[n];
		HashSet<Point> hs = new HashSet<Point>();
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			points[i] = new Point(Long.parseLong(tokenizer.nextToken()),
									Long.parseLong(tokenizer.nextToken()));
			hs.add(points[i]);
		}
		
		long count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < _2018.size(); j++) {
				Point temp = new Point(points[i].x + _2018.get(j).x, points[i].y + _2018.get(j).y);
				if (hs.contains(temp)) {
					count++;
				}
			}
		}
		count /= 2;
		System.out.println(count);
	}
		
	static class Point {
		long x;
		long y;
		Point(long _x, long _y) {
			x = _x;
			y = _y;
		}
		
		@Override
		public int hashCode() {
		    String s = Long.toString(x) + Long.toString(y);
			return s.hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
		    if (this == obj)
		        return true;
		    if (obj == null)
		        return false;
		    if (getClass() != obj.getClass())
		        return false;
		    Point other = (Point) obj;
		    if (x != other.x)
		        return false;
		    if (y != other.y)
		        return false;
		    return true;
		}
	}
}
