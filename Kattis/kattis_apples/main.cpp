#include <iostream>

using namespace std;

int main()
{
    int r, c;
    cin >> r >> c;
    char a[r][c];
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            cin >> a[i][j];
        }
    }

    for (int j = 0; j < c; j++) {
        int bot = r - 1;
        while (bot >= 0) {
            int apples = 0;
            int temp = bot;
            while (bot >= 0 && a[bot][j] != '#') {
                if (a[bot][j] == 'a') {
                    apples++;
                }
                bot--;
            }
            for (int i = temp; i > bot; i--) {
                if (apples != 0) {
                    a[i][j] = 'a';
                    apples--;
                } else {
                    a[i][j] = '.';
                }
            }
            if (bot >= 0) {
                a[bot][j] = '#';
            }
            bot--;
        }
    }

    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            cout << a[i][j];
        }
        cout << '\n';
    }
    return 0;
}
