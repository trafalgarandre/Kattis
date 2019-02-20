#include <iostream>
#include <queue>

using namespace std;

struct square {
    int i;
    int j;
};

int main()
{
    int n;
    cin >> n;
    int a[8][8];

    for (int i = 0; i < n; i++) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                a[i][j] = -1;
            }
        }
        queue<square> q;
        char c[2];
        cin >> c[0] >> c[1];
        int max_count = 0;
        square root;
        root.i = '8' - c[1];
        root.j = c[0] - 'a';
        q.push(root);
        a[root.i][root.j] = 0;
        while (!q.empty()) {
            square cur = q.front();
            q.pop();
            int row = cur.i;
            int col = cur.j;
            if (row - 2 >= 0) {
                if (col - 1 >= 0) {
                    if (a[row - 2][col - 1] == -1) {
                        a[row - 2][col - 1] = a[row][col] + 1;
                        max_count = max(max_count, a[row][col] + 1);
                        square temp = {row - 2, col - 1};
                        q.push(temp);
                    }
                }
                if (col + 1 < 8) {
                    if (a[row - 2][col + 1] == -1) {
                        a[row - 2][col + 1] = a[row][col] + 1;
                        max_count = max(max_count, a[row][col] + 1);
                        square temp = {row - 2, col + 1};
                        q.push(temp);
                    }
                }
            }
            if (row - 1 >= 0) {
                if (col - 2 >= 0) {
                    if (a[row - 1][col - 2] == -1) {
                        a[row - 1][col - 2] = a[row][col] + 1;
                        max_count = max(max_count, a[row][col] + 1);
                        square temp = {row - 1, col - 2};
                        q.push(temp);
                    }
                }
                if (col + 2 < 8) {
                    if (a[row - 1][col + 2] == -1) {
                        a[row - 1][col + 2] = a[row][col] + 1;
                        max_count = max(max_count, a[row][col] + 1);
                        square temp = {row - 1, col + 2};
                        q.push(temp);
                    }
                }
            }
            if (row + 2 < 8) {
                if (col - 1 >= 0) {
                    if (a[row + 2][col - 1] == -1) {
                        a[row + 2][col - 1] = a[row][col] + 1;
                        max_count = max(max_count, a[row][col] + 1);
                        square temp = {row + 2, col - 1};
                        q.push(temp);
                    }
                }
                if (col + 1 < 8) {
                    if (a[row + 2][col + 1] == -1) {
                        a[row + 2][col + 1] = a[row][col] + 1;
                        max_count = max(max_count, a[row][col] + 1);
                        square temp = {row + 2, col + 1};
                        q.push(temp);
                    }
                }
            }
            if (row + 1 < 8) {
                if (col - 2 >= 0) {
                    if (a[row + 1][col - 2] == -1) {
                        a[row + 1][col - 2] = a[row][col] + 1;
                        max_count = max(max_count, a[row][col] + 1);
                        square temp = {row + 1, col - 2};
                        q.push(temp);
                    }
                }
                if (col + 2 < 8) {
                    if (a[row + 1][col + 2] == -1) {
                        a[row + 1][col + 2] = a[row][col] + 1;
                        max_count = max(max_count, a[row][col] + 1);
                        square temp = {row + 1, col + 2};
                        q.push(temp);
                    }
                }
            }
        }
            cout << max_count;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (a[i][j] == max_count) {
                        cout << ' ' << (char)('a' + j) << 8 - i;
                    }
                }
            }
            cout << endl;
    }

    return 0;
}
