#include <iostream>

using namespace std;

int main()
{
    int x1, y1, x2, y2, n;
    cin >> x1 >> y1 >> x2 >> y2 >> n;
    char c[n];
    int x = x2 - x1;
    int y = y2 - y1;
    int total_x = 0;
    int total_y = 0;
    for (int i = 0; i < n; i++) {
        cin >> c[i];
        if (c[i] == 'U') {
            total_y++;
        } else if (c[i] == 'R') {
            total_x++;
        } else if (c[i] == 'D') {
            total_y--;
        } else {
            total_x--;
        }
    }

    int temp = 0;
    if (total_x * x <= 0) {
        temp += abs(total_x);
    }

    if (total_y * y <= 0) {
        temp += abs(total_y);
    }

    if (abs(total_y - y) + abs(total_x - x) > n) {

    }



    bool b[4] = {false, false, false, false};
    for (int i = 0; i < n; i++) {
        cin >> c[i];
        if (c[i] == 'U') {
            b[0] = true;
        } else if (c[i] == 'R') {
            b[1] = true;
        } else if (c[i] == 'D') {
            b[2] = true;
        } else {
            b[3] = true;
        }
    }
    bool hasMove = true;
    int a[4] = {0, 0, 0, 0}
    while (hasMove) {
        hasMove = false;
        for (int i = 0; i < n; i++) {
            if (c[i] == 'U') {
                if (y1 < y2) {
                    hasMove = true;
                    y1++;
                } else {
                    if (a[0] > 0) {
                        a[0]--;
                        a[i]--;
                    }
                }
            } else if (c[i] == 'R') {
                if (x1 < x2) {
                    hasMove = true;
                    x1++;
                }
            } else if (c[i] = 'D') {
                if (y1 > y2) {
                    hasMove = true;
                    y1--;
                }
            } else if (c[i] == 'L') {
                if (x1 > x2) {
                    hasMove = true;
                    x1--;
                }
            }
            if (hasMove) {
                if (x1 < x2) {
                    x1
                }
            }
        }
    }
    return 0;
}
