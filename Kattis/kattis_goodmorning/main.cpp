#include <iostream>

using namespace std;

struct Node {
    int row;
    int col;
};

int main()
{
    int t;
    cin >> t;
    Node a[10];
    bool check[201];
    for (int i = 1; i < 10; i++) {
        a[i].row = (i - 1) / 3;
        a[i].col = (i - 1) % 3;
    }
    a[0].row = 3;
    a[0].col = 1;
    for (int i = 0; i <= 200; i++) {
        int hundred, ten, one;
        hundred = i / 100;
        ten = i % 100 / 10;
        one = i % 10;
        if (i >= 100) {
            if (a[hundred].row <= a[ten].row && a[hundred].col <= a[ten].col
                && a[ten].row <= a[one].row && a[ten].col <= a[one].col) {
                check[i] = true;
            } else {
                check[i] = false;
            }
        } else if (i >= 10) {
            if (a[ten].row <= a[one].row && a[ten].col <= a[one].col) {
                check[i] = true;
            } else {
                check[i] = false;
            }
        } else {
            check[i] = true;
        }
    }
    int k;
    for (int i = 0; i < t; i++) {
        cin >> k;
        int temp = -1;
        int dis = 0;
        while (temp == -1) {
            if (k + dis < 201 && check[k + dis]) {
                temp = k + dis;
            }
            if (k - dis >= 0 && check[k - dis]) {
                temp = k - dis;
            }
            dis++;
        }
        cout << temp << '\n';
    }
    return 0;
}
