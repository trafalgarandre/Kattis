#include <iostream>

using namespace std;

int main()
{
    int n;
    cin >> n;
    while (n--) {
        char tt[3][3];
        int cx, co;
        cx = co = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cin >> tt[i][j];
                if (tt[i][j] == 'X') {
                    cx++;
                }
                if (tt[i][j] == 'O') {
                    co++;
                }
            }
        }
        if (cx - co != 1 && cx - co != 0) {
            cout << "no\n";
        } else {
            bool x = false;
            bool o = false;
            for (int i = 0; i < 3; i++) {
                if (tt[i][0] == tt[i][1] && tt[i][1] == tt[i][2]) {
                    if (tt[i][0] == 'X') {
                        x = true;
                    } else if (tt[i][0] == 'O') {
                        o = true;
                    }
                }
                if (tt[0][i] == tt[1][i] && tt[1][i] == tt[2][i]) {
                    if (tt[0][i] == 'X') {
                        x = true;
                    } else if (tt[0][i] == 'O') {
                        o = true;
                    }
                }
            }
            if (tt[0][0] == tt[1][1] && tt[1][1] == tt[2][2]) {
                if (tt[0][0] == 'X') {
                    x = true;
                } else if (tt[0][0] == 'O') {
                    o = true;
                }
            }
            if (tt[0][2] == tt[1][1] && tt[1][1] == tt[2][0]) {
                if (tt[0][2] == 'X') {
                    x = true;
                } else if (tt[0][2] == 'O') {
                    o = true;
                }
            }
            if (!(x && o)) {
                if (x && cx > co) {
                    cout << "yes\n";
                } else if (o && cx == co) {
                    cout << "yes\n";
                } else if (!x && !o) {
                    cout << "yes\n";
                } else {
                    cout << "no\n";
                }
            } else {
                cout << "no\n";
            }
        }
    }
    return 0;
}
