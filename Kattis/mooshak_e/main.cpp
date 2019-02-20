#include <bits/stdc++.h>

using namespace std;

int a[18];
int n;

bool check() {
    if (a[0] > a[1]) {
        return false;
    }
    for (int i = 1; i < n - 1; i++) {
        if (i % 2 == 1) {
            if (a[i] < a[i + 1]) {
                return false;
            }
        } else {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
    }
    return true;
}

long long total;

bool b[100000];
int c[18];
void exe(int x) {
    if (x == n) {
        total++;
    } else {
        for (int i = 0; i < n; i++) {
            if (!b[a[i]]) {
            if (x % 2 == 1) {
                if (a[i] > c[x - 1]) {
                    c[x] = a[i];
                    b[a[i]] = true;
                    exe(x + 1);
                    b[a[i]] = false;
                }
            } else {
                if (a[i] < c[x - 1]) {
                    c[x] = a[i];
                    b[a[i]] = true;
                    exe(x + 1);
                    b[a[i]] = false;
                }
            }
        }
        }
    }
}

int main()
{
    scanf("%d", &n);
    int d[16] = {0, 0, 0, 2, 5, 16, 61, 272, 1385, 7936, 50521, 353792, 2702765, 22368256, 199360981, 1903757312};
    while (n != 0) {
        for (int i = 0; i < n; i++) {
            scanf("%d", &a[i]);
        }
        /*
        sort(a, a + n);
        total = 0;
        for (int i = 0; i < n; i++) {
            c[0] = a[i];
            b[a[i]] = true;
            exe(1);
            b[a[i]] = false;
        }
        */
        printf("%d\n", d[n]);
        scanf("%d", &n);
    }
    return 0;
}
