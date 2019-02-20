import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class kattis_costumecontest {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		ArrayList<String> a = new ArrayList<String>();
		for(int i = 0; i < n; i++) {
			a.add(reader.readLine());
		}
		Collections.sort(a);
		String prev = a.get(0);
		int count = 1;
		ArrayList<Knight> arr = new ArrayList<Knight>();
		for (int i = 1; i < n; i++) {
			String cur = a.get(i);
			if (cur.equals(prev)) {
				count++;
			} else {
				arr.add(new Knight(count, prev));
				count = 1;
			}
			prev = cur;
		}
		arr.add(new Knight(count, prev));
		Collections.sort(arr);
		int temp = 0;
		System.out.println(arr.get(temp).name);
		temp++;
		while (temp < arr.size() && arr.get(temp).count == arr.get(temp - 1).count) {
			System.out.println(arr.get(temp).name);
			temp++;
		}
	}
	
	static class Knight implements Comparable<Knight>{
		int count;
		String name;
		Knight(int _count, String _name) {
			count = _count;
			name = _name;
		}
		
		public int compareTo(Knight other) {
			if (this.count == other.count) {
				return this.name.compareTo(other.name);
			} else {
				return this.count - other.count;
			}
		}
	}
}
