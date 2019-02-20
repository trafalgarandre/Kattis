import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_arithmetic {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		int size = s.length() * 3;
		if (s.length() % 4 != 0) {
			size = (size / 4 + 1) * 4;
		}
		byte[] a = new byte[size];
		for (int i = 0; i < size; i++) {
			a[i] = 0;
		}
		
		int pos = size - s.length() * 3;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				a[pos + 2] = 1;
			} else if (s.charAt(i) == '2') {
				a[pos + 1] = 1;
			} else if (s.charAt(i) == '3') {
				a[pos + 1] = 1;
				a[pos + 2] = 1;
			} else if (s.charAt(i) == '4') {
				a[pos] = 1;
			} else if (s.charAt(i) == '5') {
				a[pos] = 1;
				a[pos + 2] = 1;
			} else if (s.charAt(i) == '6') {
				a[pos] = 1;
				a[pos + 1] = 1;
			} else if (s.charAt(i) == '7') {
				a[pos] = 1;
				a[pos + 1] = 1;
				a[pos + 2] = 1;
			}
			pos = pos + 3;
		}
		char[] hexa = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		boolean check = false;
		for (int i = 0; i < size / 4; i++) {
			int value = a[i * 4] * 8 + a[i * 4 + 1] * 4 + a[i * 4 + 2] * 2 + a[i * 4 + 3]; 
			if (value != 0) {
				check = true;
			}
			if (check) {
				System.out.print(hexa[value]);
			}
		}
		if (!check) {
			System.out.print(0);
		}
	}
}
