import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_2048 {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		int[][] arr = new int[4][4];
		for (int i = 0; i < 4; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < 4; j++) {
				arr[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}
		
		int t = Integer.parseInt(reader.readLine());
		// left
		// move all the zero
		if (t == 0) {
			for (int i = 0; i < 4; i++) {
				int temp = 0;
				while (temp < 4) {
					if (arr[i][temp] == 0) {
						int temp2 = temp + 1;
						boolean check = false;
						while (temp2 < 4) {
							if (arr[i][temp2] != 0) {
								check = true;
							}
							arr[i][temp2 - 1] = arr[i][temp2];
							temp2++;
						}
						if (!check) {
							break;
						}
						arr[i][3] = 0;
					} else {
						temp++;
					}
				}
				temp = 0;
				while (temp < 3 && arr[i][temp] != 0) {
					if (arr[i][temp] == arr[i][temp + 1]) {
						arr[i][temp] = arr[i][temp] * 2;
						for (int j = temp + 1; j < 3; j++) {
							arr[i][j] = arr[i][j + 1];
						}
						arr[i][3] = 0;
					}
					temp++;
				}
			}
		} else if (t == 1) {
			for (int i = 0; i < 4; i++) {
				int temp = 0;
				while (temp < 4) {
					if (arr[temp][i] == 0) {
						int temp2 = temp + 1;
						boolean check = false;
						while (temp2 < 4) {
							if (arr[temp2][i] != 0) {
								check = true;
							}
							arr[temp2 - 1][i] = arr[temp2][i];
							temp2++;
						}
						if (!check) {
							break;
						}
						arr[3][i] = 0;
					} else {
						temp++;
					}
				}
				temp = 0;
				while (temp < 3 && arr[temp][i] != 0) {
					if (arr[temp][i] == arr[temp + 1][i]) {
						arr[temp][i] = arr[temp][i] * 2;
						for (int j = temp + 1; j < 3; j++) {
							arr[j][i] = arr[j + 1][i];
						}
						arr[3][i] = 0;
					}
					temp++;
				}
			}
		} else if (t == 2) {
			for (int i = 0; i < 4; i++) {
				int temp = 3;
				while (temp >= 0) {
					if (arr[i][temp] == 0) {
						int temp2 = temp - 1;
						boolean check = false;
						while (temp2 >= 0) {
							if (arr[i][temp2] != 0) {
								check = true;
							}
							arr[i][temp2 + 1] = arr[i][temp2];
							temp2--;
						}
						if (!check) {
							break;
						}
						arr[i][0] = 0;
					} else {
						temp--;
					}
				}
				
				
				temp = 3;
				while (temp > 0 && arr[i][temp] != 0) {
					if (arr[i][temp] == arr[i][temp - 1]) {
						arr[i][temp] = arr[i][temp] * 2;
						for (int j = temp - 1; j > 0; j--) {
							arr[i][j] = arr[i][j - 1];
						}
						arr[i][0] = 0;
					}
					temp--;
				}
			}
		} else {
			for (int i = 0; i < 4; i++) {
				int temp = 3;
				while (temp >= 0) {
					if (arr[temp][i] == 0) {
						int temp2 = temp - 1;
						boolean check = false;
						while (temp2 >= 0) {
							if (arr[temp2][i] != 0) {
								check = true;
							}
							arr[temp2 + 1][i] = arr[temp2][i];
							temp2--;
						}
						if (!check) {
							break;
						}
						arr[0][i] = 0;
					} else {
						temp--;
					}
				}
				
				
				temp = 3;
				while (temp > 0 && arr[temp][i] != 0) {
					if (arr[temp][i] == arr[temp - 1][i]) {
						arr[temp][i] = arr[temp][i] * 2;
						for (int j = temp - 1; j > 0; j--) {
							arr[j][i] = arr[j - 1][i];
						}
						arr[0][i] = 0;
					}
					temp--;
				}
			}
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
