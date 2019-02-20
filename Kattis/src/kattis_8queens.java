import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class kattis_8queens {
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] c = new boolean[8][8];
        for (int i = 0; i < 8; i++) {
            String temp = reader.readLine();
            for (int j = 0; j < 8; j++) {
                c[i][j] = temp.charAt(j) == '*';
            }
        }
        int count = 0;
        boolean check = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (c[i][j]) {
                    count++;
                    for (int k = 0; k < 8; k++) {
                        if (k != i && c[k][j]) {
                            check = false;
                        }
                        if (k != j && c[i][k]) {
                            check = false;
                        }
                    }
                    int temp_i = i - 1;
                    int temp_j = j - 1;
                    while (temp_i >= 0 && temp_j >= 0) {
                        if (c[temp_i][temp_j]) {
                            check = false;
                        }
                        temp_i--;
                        temp_j--;
                    }
                    
                    temp_i = i + 1;
                    temp_j = j + 1;
                    while (temp_i < 8 && temp_j < 8) {
                        if (c[temp_i][temp_j]) {
                            check = false;
                        }
                        temp_i++;
                        temp_j++;
                    }
                    
                    temp_i = i + 1;
                    temp_j = j - 1;
                    while (temp_i < 8 && temp_j >= 0) {
                        if (c[temp_i][temp_j]) {
                            check = false;
                        }
                        temp_i++;
                        temp_j--;
                    }
                    
                    temp_i = i - 1;
                    temp_j = j + 1;
                    while (temp_i >= 0 && temp_j < 8) {
                        if (c[temp_i][temp_j]) {
                            check = false;
                        }
                        temp_i--;
                        temp_j++;
                    }
                }
            }
        }
        if (count != 8) {
            check = false;
        }
        if (check) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }
    }
}
