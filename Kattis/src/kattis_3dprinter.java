import java.util.Scanner;


public class kattis_3dprinter {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int[] ranger = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192};
		for (int i = 0; i < ranger.length; i++) {
			int temp = n / ranger[i];
			if (n % ranger[i] != 0) {
				temp++;
			}
			if (temp + i < min) {
				min = temp + i;
			}
		}
		System.out.println(min);
	}
}
