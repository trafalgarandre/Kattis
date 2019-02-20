#include <bits/stdc++.h>

using namespace std;
int c, n, f[2001][2001], v[2001], w[2001];

int val(int id, int remW) {
    if (remW == 0) {
        f[id][remW] = 0;
    } else if (id == n) {
        f[id][remW] = 0;
    } else if (f[id][remW] == 0) {
        if (w[id] > remW) {
            f[id][remW] = val(id + 1, remW);
        } else if (w[id] <= remW) {
            f[id][remW] = max(val(id + 1, remW), v[id] + val(id + 1, remW - w[id]));
        }
    }
    return f[id][remW];
}

int main()
{
    double temp;
    while(scanf("%lf", &temp) != EOF) {
        c = floor(temp);
        scanf("%d", &n);
        memset(f, 0, sizeof(f[0][0]) * (n + 1) * (c + 1));
        for (int i = 0; i < n; i++) {
            scanf("%d %d", &v[i], &w[i]);
        }
        val(0, c);
        int m = 0;
        int b[5001];
        int id = 0, remW = c;
        while (id < n && f[id][remW] != 0) {
            if (id == n - 1) {
                b[m] = id;
                id++;
                m++;
            } else if (f[id + 1][remW] == f[id][remW]) {
                id++;
            } else {
                b[m] = id;
                remW -= w[id];
                id++;
                m++;
            }
        }
        cout << m << '\n';
        for (int i = 0; i < m; i++) {
            cout << b[i] << ' ';
        }
        cout << '\n';
    }
    return 0;
}
