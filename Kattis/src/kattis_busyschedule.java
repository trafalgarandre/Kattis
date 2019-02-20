import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class kattis_busyschedule {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		while (n != 0) {
			ArrayList<Time> times = new ArrayList<Time>(n);
			for (int i = 0; i < n; i++) {
				times.add(new Time(reader.readLine()));
			}
			Collections.sort(times);
			for (Time time: times) {
				System.out.println(time.s);
			}
			n = Integer.parseInt(reader.readLine());
			if (n != 0) {
				System.out.println();
			}
		}
	}
	
	static class Time implements Comparable<Time> {
		int value;
		String s;
		
		Time(String _s) {
			StringTokenizer tokenizer = new StringTokenizer(_s);
			s = _s;
			String time = tokenizer.nextToken();
			String type = tokenizer.nextToken();
			tokenizer = new StringTokenizer(time);
			value = 60 * Integer.parseInt(tokenizer.nextToken(":")) + Integer.parseInt(tokenizer.nextToken(":"));
			if (type.equals("a.m.")) {
				value %= 720; 
			} else {
				value %= 720;
				value += 720;
			}
		}
		
		public int compareTo(Time other) {
			return this.value - other.value;
		}
	}
}
