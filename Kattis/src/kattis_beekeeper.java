import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_beekeeper {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		while (n != 0) {
			int max = -1;
			String favorite = null;
			String temp;
			int temp_pair;
			for (int i = 0; i < n; i++) {
				temp = reader.readLine();
				temp_pair = 0;
				for (int j = 0; j < temp.length() - 1; j++) {
					if (temp.charAt(j) == temp.charAt(j + 1)) {
						char temp_char = temp.charAt(j);
						if (temp_char == 'a' || temp_char == 'e' ||
							temp_char == 'i' || temp_char == 'o' ||
							temp_char == 'u' || temp_char == 'y') {
							temp_pair++;
						}
					}
				}
				if (temp_pair > max) {
					max = temp_pair;
					favorite = temp;
				}
			}
			System.out.println(favorite);
			n = Integer.parseInt(reader.readLine());
		}
	}
}
