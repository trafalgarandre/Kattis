#include <bits/stdc++.h>

using namespace std;
int n, k, q, x[1000001];
long long seq[1000001];
int main()
{
    scanf("%d %d", &n, &k);
    memset(x, 0, sizeof(x));
    memset(seq, 0, sizeof(seq));
    for (int i = 0; i < k; i++) {
        int temp;
        scanf("%d", &temp);
        x[temp]++;
    }
    for (int i = 1; i <= n; i++) {
        if (x[i] != 0) {
            int temp = 0;
            while (temp * i <= n) {
                seq[temp * i] += x[i];
                temp++;
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        seq[i] += seq[i - 1];
    }

    scanf("%d", &q);
    for (int i = 0; i < q; i++) {
        int l, r;
        scanf("%d %d", &l, &r);
        if (l == 0) {
            cout << seq[r] << '\n';
        } else {
            cout << seq[r] - seq[l - 1] << '\n';
        }
    }
    return 0;
}
