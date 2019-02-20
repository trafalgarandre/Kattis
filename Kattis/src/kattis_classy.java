import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;


public class kattis_classy {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(reader.readLine());
			ArrayList<Person> person = new ArrayList<Person>(n);
			for (int j = 0; j < n; j++) {
				String line = reader.readLine();
				StringTokenizer tokenizer = new StringTokenizer(line, ": ");
				person.add(new Person(tokenizer.nextToken(), tokenizer.nextToken()));
			}
			Collections.sort(person);
			for (int j = n - 1; j >= 0; j--) {
				System.out.println(person.get(j).name);
			}
			for (int j = 0; j < 30; j++) {
				System.out.print("=");
			}
			System.out.println();
		}
	}
	
	public static class Person implements Comparable<Person>{
		String name;
		LinkedList<Integer> level;
		public Person(String _name, String s) {
			name = _name;
			
			StringTokenizer tokenizer = new StringTokenizer(s);
			String s_level = tokenizer.nextToken();
			tokenizer = new StringTokenizer(s_level, "-");
			level = new LinkedList<Integer>();
			while (tokenizer.hasMoreTokens()) {
				String current = tokenizer.nextToken();
				int toAdd;
				if (current.equals("lower")) {
					toAdd = 0;
				} else if (current.equals("middle")) {
					toAdd = 1;
				} else {
					toAdd = 2;
				}
				level.addFirst(toAdd);
			}
		}
		
		public int compareTo(Person other) {
			ListIterator<Integer> this_Iter = this.level.listIterator();
			ListIterator<Integer> other_Iter = other.level.listIterator();
			while (this_Iter.hasNext() && other_Iter.hasNext()) {
				int this_cur = this_Iter.next();
				int other_cur = other_Iter.next();
				if (this_cur != other_cur) {
					return this_cur - other_cur;
				}
			}
			return other.name.compareTo(this.name);
		}
	}
}
