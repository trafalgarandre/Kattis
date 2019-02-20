import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class kattis_baconeggsandspam {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n;
		while ((n = Integer.parseInt(reader.readLine())) != 0) {
			ArrayList<Food> foods = new ArrayList<Food>();
			for (int i = 0; i < n; i++) {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				String name = tokenizer.nextToken();
				while (tokenizer.hasMoreTokens()) {
					String temp = tokenizer.nextToken();
					boolean has = false;
					for (Food food: foods) {
						if (food.food.equals(temp)) {
							has = true;
							food.name.add(name);
						}
					}
					if (!has) {
						Food cur = new Food(temp);
						cur.name.add(name);
						foods.add(cur);
					}
				}
			}
			for (Food food:foods) {
				Collections.sort(food.name);
			}
			Collections.sort(foods);
			for (int i = 0; i < foods.size(); i++) {
				Food food = foods.get(i);
				System.out.print(food.food);
				for (String s: food.name) {
					System.out.print(" " + s);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	static class Food implements Comparable<Food>{
		String food;
		ArrayList<String> name;
		Food(String _food) {
			food = _food;
			name = new ArrayList<String>();
		}
		@Override
		public int compareTo(Food o) {
			// TODO Auto-generated method stub
			return this.food.compareTo(o.food);
		}
	}
}
