import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class kattis_fbiuniversal {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int p = Integer.parseInt(reader.readLine());
		char[] c = {'0','1' ,'2' ,'3' ,'4' ,'5' ,'6' ,'7', '8' ,'9' ,'A' ,'C' ,'D' ,'E' 
				,'F' ,'H','J' ,'K' ,'L' ,'M' ,'N' ,'P' ,'R' ,'T' ,'V' ,'W' ,'X'};
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < c.length; i++) {
			map.put(c[i], i);
		}
		for (int i = 0; i < p; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			System.out.print(Integer.parseInt(tokenizer.nextToken()) + " ");
			String s = tokenizer.nextToken();
			char[] str = s.toCharArray();
			for (int j = 0; j < s.length(); j++) {
				if (str[j] == 'B') {
					str[j] = '8';
				} else if (str[j] == 'G') {
					str[j] = 'C';
				} else if (str[j] == 'I') {
					str[j] = '1';
				} else if (str[j] == 'O' || str[j] == 'Q') {
					str[j] = '0';
				} else if (str[j] == 'S') {
					str[j] = '5';
				} else if (str[j] == 'U' || str[j] == 'Y') {
					str[j] = 'V';
				} else if (str[j] == 'Z') {
					str[j] = '2';
				}
			}
			int d = (2 * map.get(str[0]) + 4 * map.get(str[1]) + 5 * map.get(str[2])
					+ 7 * map.get(str[3]) + 8 * map.get(str[4]) + 10 * map.get(str[5])
					+ 11 * map.get(str[6]) + 13 * map.get(str[7])) % 27;
			if (d != map.get(str[8])) {
				System.out.println("Invalid");
			} else {
				long temp = 0;
				long multi = 1;
				for (int j = 7; j >= 0; j--) {
					temp = temp + (map.get(str[j])) * multi;
					multi *= 27;
				}
				System.out.println(temp);
			}
		}
	}
}
