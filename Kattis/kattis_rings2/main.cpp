#include <bits/stdc++.h>

using namespace std;

int gr[4] = {-1, 0, 0, 1};
int gc[4] = {0, -1, 1, 0};

int main()
{
    int n, m;
    cin >> n >> m;
    char a[n][m];
    int b[n][m];
    int maxi = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> a[i][j];
        }
    }

    queue<pair<int, int>> v;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (a[i][j] == '.') {
                for (int k = 0; k < 4; k++) {
                    int temp_r = i + gr[k];
                    int temp_c = j + gc[k];
                    if (temp_r >= 0 && temp_r < n && temp_c >= 0 && temp_c < m) {
                        if (a[temp_r][temp_c] == 'T') {
                            a[temp_r][temp_c] = ' ';
                            b[temp_r][temp_c] = 1;
                            maxi = 1;
                            v.push(make_pair(temp_r, temp_c));
                        }
                    }
                }
            }
            if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                if (a[i][j] == 'T') {
                    a[i][j] = ' ';
                    b[i][j] = 1;
                    maxi = 1;
                    v.push(make_pair(i, j));
                }
            }
        }
    }

    while (!v.empty()) {
        pair<int, int> cur = v.front();
        int i = cur.first;
        int j = cur.second;
        if (b[i][j] > maxi) {
            maxi = b[i][j];
        }
        for (int k = 0; k < 4; k++) {
            int temp_r = i + gr[k];
            int temp_c = j + gc[k];
            if (temp_r >= 0 && temp_r < n && temp_c >= 0 && temp_c < m) {
                if (a[temp_r][temp_c] == 'T') {
                    b[temp_r][temp_c] = b[i][j] + 1;
                    a[temp_r][temp_c] = ' ';
                    v.push(make_pair(temp_r, temp_c));
                }
            }
        }
        v.pop();
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (maxi < 10) {
                if (a[i][j] == '.') {
                    cout << "..";
                } else {
                    cout << "." << (char)(b[i][j] + '0');
                }
            } else {
                if (a[i][j] == '.') {
                    cout << "...";
                } else if (b[i][j] < 10){
                    cout << ".." << (char)(b[i][j] + '0');
                } else {
                    cout << "." << to_string(b[i][j]);
                }
            }
        }
        cout << '\n';
    }
    return 0;
}
