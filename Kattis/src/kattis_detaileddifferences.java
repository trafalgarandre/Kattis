import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_detaileddifferences {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		for (int i = 0; i < n; i++) {
			char[] s1 = reader.readLine().toCharArray();
			char[] s2 = reader.readLine().toCharArray();
			System.out.println(new String(s1));
			System.out.println(new String(s2));
			for (int j = 0; j < s1.length; j++) {
				if (s1[j] == s2[j]) {
					System.out.print('.');
				} else {
					System.out.print('*');
				}
			}
			System.out.println();
			System.out.println();
		}
	}
}
