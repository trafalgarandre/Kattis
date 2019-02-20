import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class kattis_babelfish {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		StringTokenizer tokenizer;
		boolean flag = false;
		HashMap<String, String> map = new HashMap<String, String>();
		while((str = reader.readLine()) != null) {
			if (str.length() == 0) {
				flag = true;
				continue;
			}
		    if (!flag) {
		    	tokenizer = new StringTokenizer(str);
		    	String s1 = tokenizer.nextToken();
		    	String s2 = tokenizer.nextToken();
		    	map.put(s2, s1);
		    } else {
		    	if (map.containsKey(str)) {
		    		System.out.println(map.get(str));
		    	} else {
		    		System.out.println("eh");
		    	}
		    }
		}
	}
}
