#include <bits/stdc++.h>

using namespace std;

int a[21];
int b[21];
int n;
int total;
int ma;

void solve(int id, int current) {
    if (current >= total / 2 + total % 2) {
        if (current < ma) {
            ma = current;
        }
    } else {
        if (id < n) {
            if (current + total - b[id] >= total / 2 + total % 2) {
                solve(id + 1, current);
            }
            if (current + a[id] + total - b[id] >= total / 2 + total % 2) {
                solve(id + 1, current + a[id]);
            }
        }
    }
}

int main()
{
    scanf("%d", &n);
    while (n != 0) {
        total = 0;
        scanf("%d", &a[0]);
        b[0] = a[0];
        total += a[0];
        for (int i = 1; i < n; i++) {
            scanf("%d", &a[i]);
            total += a[i];
            b[i] = b[i - 1] + a[i];
        }
        ma = total;
        sort(a, a + n, greater<int>());
        solve(0, 0);
        printf("%d %d\n", ma, total - ma);
        scanf("%d", &n);
    }
    return 0;
}
