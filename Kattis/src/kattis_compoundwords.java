import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class kattis_compoundwords {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		TreeSet<String> ts = new TreeSet<String>();
		String s;
		ArrayList<String> a = new ArrayList<String>();
		while ((s = reader.readLine()) != null && s.length() != 0) {
			StringTokenizer tokenizer = new StringTokenizer(s);
			while (tokenizer.hasMoreTokens()) {
				a.add(tokenizer.nextToken());
			}
		}
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.size(); j++) {
				if (i != j) {
					ts.add(a.get(i).concat(a.get(j)));
				}
			}
		}
		Iterator<String> iter = ts.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
