import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_gamerank {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		int[] max = new int[26];
		for (int i = 1; i <= 10; i++) {
			max[i] = 5;
		}
		
		for (int i = 11; i <= 15; i++) {
			max[i] = 4;
		}
		
		for (int i = 16; i <= 20; i++) {
			max[i] = 3;
		}
		
		for (int i = 21; i <= 25; i++) {
			max[i] = 2;
		}
		
		int rank = 25;
		int star = 0;
		int consecutive = 0;
		for (char c: s.toCharArray()) {
			if (rank == 0) {
				break;
			}
			if (c == 'L') {
				consecutive = 0;
				if (rank <= 20) {
					if (star == 0) {
						if (rank != 20) {
							rank++;
							star = max[rank] - 1;
						}
					} else {
						star--;
					}
				}
			} else {
				star++;
				consecutive++;
				if (rank >= 6 && consecutive > 2) {
					star++;
				}
				if (star > max[rank]) {
					star = star - max[rank];
					rank--;
				}
			}
		}
		
		if (rank == 0) {
			System.out.println("Legend");
		} else {
			System.out.println(rank);
		}
	}
}
