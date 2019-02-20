import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class kattis_wordcloud {
	public static void main(String args[]) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int w = Integer.parseInt(tokenizer.nextToken());
		int n = Integer.parseInt(tokenizer.nextToken());
		int index = 0;
		while (w != 0 && n != 0) {
			index++;
			int max_count = 0;
			ArrayList<Word> a = new ArrayList<Word>();
			for (int i = 0; i < n; i++) {
				tokenizer = new StringTokenizer(reader.readLine());
				String s = tokenizer.nextToken();
				int count = Integer.parseInt(tokenizer.nextToken());
				if (count > max_count) {
					max_count = count;
				}
				a.add(new Word(s, count));
			}
			Word.max = max_count;
			int left = w;
			int total_height = 0;
			int row_height = 0;
			for (Word word: a) {
				if (left < word.getWidth()) {
					total_height += row_height;
					left = w;
					row_height = 0;
				}
				if (word.getFont() > row_height) {
					row_height = word.getFont();
				}
				left = left - word.getWidth() - 10;
			}
			total_height += row_height;
			System.out.println("CLOUD " + index + ": " + total_height);
			tokenizer = new StringTokenizer(reader.readLine());
			w = Integer.parseInt(tokenizer.nextToken());
			n = Integer.parseInt(tokenizer.nextToken());
		}
	}
	
	static class Word {
		static int max = 0;
		String s;
		int count;
		Word(String _s, int _count) {
			s = _s;
			count = _count;
		}
		
		int getFont() {
			return 8 + (int)Math.ceil(((double)40 * (count - 4)) / ((double)max - 4));
		}
		
		int getWidth() {
			return (int)Math.ceil((double)9 / 16 * s.length() * getFont());
		}
 	}
}
