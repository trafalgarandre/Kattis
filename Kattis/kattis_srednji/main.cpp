#include <bits/stdc++.h>

using namespace std;

int a[110000], l[200001], r[200001];

int main()
{
    int n, b;
    cin >> n >> b;
    int pos = -1;
    for (int i = 0; i < n ; i++) {
        cin >> a[i];
        if (a[i] == b) {
            pos = i;
        }
    }
    if (pos == -1) {
        cout << 0;
    } else {
        for (int i = 0; i < 200001; i++) {
            l[i] = 0;
            r[i] = 0;
        }
        int ls = pos - 1;
        int sub = 100000;
        while (ls >= 0) {
            if (a[ls] > b) {
                sub++;
            } else {
                sub--;
            }
            l[sub]++;
            ls--;
        }

        int rs = pos + 1;
        sub = 100000;
        while (rs < n) {
            if (a[rs] > b) {
                sub++;
            } else {
                sub--;
            }
            r[sub]++;
            rs++;
        }
        long long result = 1 + l[100000] + r[100000];
        for (int i = 0; i < 200001; i++) {
            result += (l[i] * r[200000 - i]);
        }
        cout << result;
    }
    return 0;
}
