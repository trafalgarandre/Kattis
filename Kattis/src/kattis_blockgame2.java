import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_blockgame2 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		long x = Long.parseLong(tokenizer.nextToken());
		long y = Long.parseLong(tokenizer.nextToken());
		boolean isMe = true;
		while (true) {
			long l = x > y ? x : y;
			long s = x < y ? x : y;
			if (l % s == 0) {
				break;
			} else if (l / s > 1) {
				break;
			} else {
				x = l % s;
				y = s;
			}
			isMe = !isMe;
		}
		System.out.println(isMe ? "win" : "lose");
	}
}
