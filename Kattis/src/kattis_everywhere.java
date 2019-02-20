import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class kattis_everywhere {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(reader.readLine());
			HashSet<String> hs = new  HashSet<String>();
			for (int j = 0; j < n; j++) {
				hs.add(reader.readLine());
			}
			System.out.println(hs.size());
		}
	}
}
