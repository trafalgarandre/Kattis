import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_acm {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int time, totalTime = 0, ACproblem = 0;
		boolean[] isAccepted = new boolean[30];
		int[] wrongCount = new int[30];
		for (int i = 0; i < 30; i++) {
			isAccepted[i] = false;
			wrongCount[i] = 0;
		}
		while ((time = Integer.parseInt(tokenizer.nextToken())) != -1) {
			int problem = tokenizer.nextToken().toCharArray()[0] - 'A';
			boolean result = tokenizer.nextToken().equals("right") ? true : false;
			if (!isAccepted[problem]) {
				if (result) {
					totalTime = totalTime + time + 20 * wrongCount[problem];
					ACproblem++;
					isAccepted[problem] = true;
				} else {
					wrongCount[problem]++;
				}
			}
			tokenizer = new StringTokenizer(reader.readLine());
		}
		System.out.println(ACproblem + " " + totalTime);
	}
}
