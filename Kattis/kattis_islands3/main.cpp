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
    cin >> r >> c;
    char a[r][c];
    bool b[r][c];
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            cin >> a[i][j];
            b[i][j] = false;
        }
    }
    int result = 0;
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            if (a[i][j] == 'L' && !b[i][j]) {
                result++;
                b[i][j] = true;
                queue<grid> q;
                grid first;
                first.c = j;
                first.r = i;
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
                            if (!b[temp_r][temp_c] && a[temp_r][temp_c] != 'W') {
                                b[temp_r][temp_c] = true;
                                grid g;
                                g.r = temp_r;
                                g.c = temp_c;
                                q.push(g);
                            }
                        }
                    }
                }
            }
        }
    }
    cout << result;
    return 0;
}


