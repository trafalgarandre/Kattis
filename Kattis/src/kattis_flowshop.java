import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class kattis_flowshop { 
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        long[][] a = new long[2][m];
        tokenizer = new StringTokenizer(reader.readLine());
        a[0][0] = Long.parseLong(tokenizer.nextToken());
        for (int i = 1; i < m; i++) {
            a[0][i] = a[0][i - 1] + Long.parseLong(tokenizer.nextToken());
        }
        System.out.print(a[0][m - 1]);
        for (int i  = 1; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            a[i % 2][0] = Long.parseLong(tokenizer.nextToken()) + a[(i + 1) % 2][0];
            for (int j = 1; j < m; j++) {
                long temp = Long.parseLong(tokenizer.nextToken());
                a[i % 2][j] = Math.max(a[(i + 1) % 2][j], a[i % 2][j - 1]) + temp;
            }
            System.out.print(" " + a[i % 2][m - 1]);
        }
    }
}
