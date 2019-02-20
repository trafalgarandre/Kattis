#include <iostream>
#include <queue>

using namespace std;

int dr[] = {-1, 0, 1, 0};
int dc[] = {0, 1, 0, -1};

struct grid {
    int r,c;
};

int main()
{
    int r, c;
    cin >> c >> r;
    int a[r][c];
    bool b[r][c];
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            cin >> a[i][j];
            b[i][j] = false;
        }
    }
    int result = 0;
    queue<grid> q;
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            if (!b[i][j]) {
                b[i][j] = true;
                int total = 1;
                bool willAdd = true;
                grid first;
                first.r = i;
                first.c = j;
                q.push(first);
                while (!q.empty()) {
                    grid cur = q.front();
                    q.pop();
                    for (int k = 0; k < 4; k++) {
                        int temp_r = cur.r + dr[k], temp_c = cur.c + dc[k];
                        if (temp_r < 0 || temp_r == r
                            || temp_c < 0 || temp_c == c) {
                            continue;
                        } else {
                            if (a[temp_r][temp_c] < a[cur.r][cur.c]) {
                                willAdd = false;
                            }
                            if (!b[temp_r][temp_c]) {
                                if (a[temp_r][temp_c] == a[cur.r][cur.c]) {
                                    b[temp_r][temp_c] = true;
                                    total++;
                                    grid g;
                                    g.r = temp_r;
                                    g.c = temp_c;
                                    q.push(g);
                                }
                            }
                        }
                    }
                }
                if (willAdd) {
                    result += total;
                }
            }
        }
    }
    cout << result;

    return 0;
}
