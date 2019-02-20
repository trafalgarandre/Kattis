import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class kattis_pachydermpeanutpacking {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n;
		boolean is_first = true;
		while ((n = Integer.parseInt(reader.readLine())) != 0) {
			ArrayList<Box> boxes = new ArrayList<Box>();
			if (!is_first) {
				System.out.println();
			} else {
				is_first = false;
			}
			for (int i = 0; i < n; i++) {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				Coordinate c1 = new Coordinate(Double.parseDouble(tokenizer.nextToken()),
						Double.parseDouble(tokenizer.nextToken()));
				Coordinate c2 = new Coordinate(Double.parseDouble(tokenizer.nextToken()),
						Double.parseDouble(tokenizer.nextToken()));
				boxes.add(new Box(tokenizer.nextToken(), c1, c2));
			}
			int m = Integer.parseInt(reader.readLine());
			for (int i = 0; i < m; i++) {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				Coordinate c = new Coordinate(Double.parseDouble(tokenizer.nextToken())
						, Double.parseDouble(tokenizer.nextToken()));
				String s = tokenizer.nextToken();
				System.out.print(s + " ");
				boolean check = false;
				for (Box box: boxes) {
					if (box.small.isSmaller(c) && c.isSmaller(box.large)) {
						check = true;
						if (box.name.equals(s)) {
							System.out.println("correct");
						} else {
							System.out.println(box.name);
						}
					}
				}
				if (!check) {
					System.out.println("floor");
				}
			}
		}
	}
	
	static class Coordinate {
		double x;
		double y;
		Coordinate(double _x, double _y) {
			x = _x;
			y = _y;
		}
		
		public boolean isSmaller(Coordinate other) {
			return x <= other.x && y <= other.y;
		}
	}
	
	static class Box {
		String name;
		Coordinate small, large;
		Box(String _s, Coordinate _c1, Coordinate _c2) {
			name = _s;
			small = _c1;
			large = _c2; 
		}
	}
}
