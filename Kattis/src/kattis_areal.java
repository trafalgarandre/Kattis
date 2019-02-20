import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_areal {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		double a = Double.parseDouble(reader.readLine());
		System.out.println(Math.sqrt(a) * 4);
	}
}
