#include <bits/stdc++.h>

using namespace std;
typedef vector<int> vi;
typedef vector<vi> vvi;

int m, n;
int c[20];
unordered_map<string, int> hmap;
bool e[20][20];
int total, order, color;

void process(int x) {
    if (color < total) {
        if (x == order) {
            if (total > color) total = color;
        } else {
            for (int i = 0; i < color; i++) {
                bool can = true;
                for (int j = 0; j < x; j++) {
                    if (e[x][j] && c[j] == i) {
                        can = false;
                    }
                }
                if (can) {
                    c[x] = i;
                    process(x + 1);
                    c[x] = -1;
                }
            }
            c[x] = color;
            color++;
            process(x + 1);
            color--;
            c[x] = -1;

        }
    }
}

int main()
{
    cin >> n >> m;
    while (n != 0) {
        string s1, s2;
        int i1, i2;
        order = 0;
        hmap.clear();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                e[i][j] = false;
            }
        }
        for (int i = 0; i < m; i++) {
            cin >> s1 >> s2;
            //transform(s1.begin(), s1.end(),s1.begin(), ::toupper);
            //transform(s2.begin(), s2.end(),s2.begin(), ::toupper);
            if (hmap.find(s1) == hmap.end()) {
                hmap.emplace(s1, order);
                c[order] = -1;
                order++;
            }
            if (hmap.find(s2) == hmap.end()) {
                hmap.emplace(s2, order);
                c[order] = -1;
                order++;
            }
            i1 = hmap[s1];
            i2 = hmap[s2];
            e[i1][i2] = true;
            e[i2][i1] = true;
        }
        total = n + 1;
        color = 1;
        process(0);
        if (total > n) {
            cout << 1 << '\n';
        } else {
            cout << total << '\n';
        }
        cin >> n >> m;
    }
    return 0;
}
