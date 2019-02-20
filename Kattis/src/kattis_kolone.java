import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_kolone {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n1 = Integer.parseInt(tokenizer.nextToken());
		int n2 = Integer.parseInt(tokenizer.nextToken());
		Ant[] ants = new Ant[n1 + n2];
		String line1 = reader.readLine();
		for (int i = n1 - 1; i >= 0; i--) {
			ants[i] = new Ant(false, line1.charAt(n1 - 1 - i));
		}
		String line2 = reader.readLine();
		for (int i = n1; i < n1 + n2; i++) {
			ants[i] = new Ant(true, line2.charAt(i - n1));
		}
		
		int t = Integer.parseInt(reader.readLine());
		for (int j = 0; j < t; j++) {
			for (int i = 0; i < n1 + n2 - 1; i++) {
				if (!ants[i].dir && ants[i + 1].dir) {
					Ant temp = ants[i];
					ants[i] = ants[i + 1];
					ants[i + 1] = temp;
					i++;
				}
			}
		}
		for (int i = 0; i < n1 + n2; i++) {
			System.out.print(ants[i].name);
		}
	}
	
	static class Ant {
		boolean dir;
		char name;
		Ant(boolean _dir, char c) {
			dir = _dir;
			name = c;
		}
	}
}
