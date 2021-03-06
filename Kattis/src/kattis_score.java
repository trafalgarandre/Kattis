import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_score {
	public static void main(String args[]) throws NumberFormatException, IOException { 
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] a = new int[2][2];
		int prevTime = 0;
		int isH = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int who = tokenizer.nextToken().equals("H") ? 0 : 1;
			int point = Integer.parseInt(tokenizer.nextToken());
			int time = convertToTime(tokenizer.nextToken());
			a[who][0] += point;
			if (isH == 1) {
				a[0][1] = a[0][1] + time - prevTime;
			} else if (isH == 2) {
				a[1][1] = a[1][1] + time - prevTime;
			}
			if (a[0][0] > a[1][0]) {
				isH = 1;
			} else if (a[0][0] < a[1][0]){
				isH = 2;
			} else {
				isH = 0;
			}
			prevTime = time;
			
		}
		if (isH == 1) {
			a[0][1] = a[0][1] + 32 * 60 - prevTime;
		} else if (isH == 2) {
			a[1][1] = a[1][1] + 32 * 60 - prevTime;
		}
		if (isH == 1) {
			System.out.println("H " + convertToTime(a[0][1]) + " " + convertToTime(a[1][1]));
		} else if (isH == 2) {

			System.out.println("A " + convertToTime(a[0][1]) + " " + convertToTime(a[1][1]));
		}
	}
	
	static int convertToTime(String s) {
		StringTokenizer tokenizer = new StringTokenizer(s);
		return Integer.parseInt(tokenizer.nextToken(":")) * 60 + Integer.parseInt(tokenizer.nextToken(":"));
	}
	
	static String convertToTime(int time) {
		return Integer.toString(time / 60) + ":" + String.format("%02d", time % 60);
	}
}
