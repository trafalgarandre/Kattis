import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;


public class kattis_addingwords {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		String line;
		while((line = reader.readLine()) != null)  {
			tokenizer = new StringTokenizer(line);
			String type = tokenizer.nextToken();
			if (type.equals("clear")) {
				hashMap.clear();
			} else if (type.equals("def")) {
				hashMap.put(tokenizer.nextToken(), Integer.parseInt(tokenizer.nextToken()));
			} else {
				String variable = tokenizer.nextToken();
				int value = 0;
				if (!hashMap.containsKey(variable)) {
					System.out.println(line.substring(5, line.length()) + " unknown");
					continue;
				} else {
					value += hashMap.get(variable);
				}
				String operator = tokenizer.nextToken();
				boolean check = true;
				while (!operator.equals("=")) {
					variable = tokenizer.nextToken();
					if (!hashMap.containsKey(variable)) {
						System.out.println(line.substring(5, line.length()) + " unknown");
						check = false;
						break;
					} else {
						if (operator.equals("+")) {
							value += hashMap.get(variable);
						} else {
							value -= hashMap.get(variable);
						}
					}
					operator = tokenizer.nextToken();
				}
				if (check) {
					if (hashMap.containsValue(value)) {
						for (Entry<String, Integer> entry: hashMap.entrySet()) {
							if (entry.getValue() == value) {
								System.out.println(line.substring(5, line.length()) + " " + entry.getKey());
								break;
							}
						}
					} else {
						System.out.println(line.substring(5, line.length()) + " unknown");
					}
				}
			}
		}
	}
}
