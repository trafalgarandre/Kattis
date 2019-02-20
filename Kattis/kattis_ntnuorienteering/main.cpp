#include <bits/stdc++.h>

using namespace std;
int t, c, l, a[201][201], ma, dist[201][201];

struct lec {
    int id, start, ends;
};

bool cmp(lec x, lec y) {
    return x.start < y.start;
}

void floydWarshall ()
{

    int i, j, k;

    for (i = 0; i < c; i++)
        for (j = 0; j < c; j++)
            dist[i][j] = a[i][j];

    for (k = 0; k < c; k++)
    {

        for (i = 0; i < c; i++)
        {

            for (j = 0; j < c; j++)
            {

                if (dist[i][k] + dist[k][j] < dist[i][j])
                    dist[i][j] = dist[i][k] + dist[k][j];
            }
        }
    }
}

int main()
{
    scanf("%d", &t);
    while (t--) {
        memset(a, 0, sizeof(a));
        memset(dist, 0, sizeof(dist));
        scanf("%d %d", &c, &l);
        lec lecs[l];
        int f[l];
        ma = 1;
        memset(f, 0, sizeof(f));
        for (int i = 0; i <  c * (c - 1) / 2; i++) {
            int x, y, z;
            scanf("%d %d %d", &x, &y, &z);
            a[x][y] = z;
            a[y][x] = z;
        }
        floydWarshall();
        for (int i = 0; i < l; i++) {
            scanf("%d %d %d", &lecs[i].id, &lecs[i].start, &lecs[i].ends);
            f[i] = 1;
        }
        sort(lecs, lecs + l, cmp);
        for (int i = 1; i < l; i++) {
            for (int j = 0; j < i; j++) {
                if (lecs[i].start - lecs[j].ends >= dist[lecs[i].id][lecs[j].id] && f[j] + 1 > f[i]) {
                    f[i] = f[j] + 1;
                }
            }
            if (f[i] > ma) {
                ma = f[i];
            }
        }
        printf("%d\n", ma);
    }
    return 0;
}
