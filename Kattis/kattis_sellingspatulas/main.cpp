#include <bits/stdc++.h>

using namespace std;
double a[1500];
int temp;
int n;
int main()
{
    cout << fixed << setprecision(2);
    cin >> n;
    while (n != 0) {
        memset(a, 0, sizeof(a));
        for (int i = 0; i < n; i++) {
            cin >> temp;
            cin >> a[temp];
        }
        int l = 0;
        double ma = 0;
        int ll, lr;
        double cur = 0;
        for (int i = 0; i < 1440; i++) {
            cur = cur - 0.08 + a[i];
            if (cur <= 0) {
                l = i + 1;
                cur = 0;
            } else {
                if (cur > ma) {
                    ma = cur;
                    ll = l;
                    lr = i;
                } else if (cur == ma && i - l + 1 < lr - ll + 1) {
                    ll = l;
                    lr = i;
                }
            }
        }
        if (ma == 0) {
            cout << "no profit\n";
        } else {
            cout << ma << ' ' << ll << ' ' << lr << '\n';
        }
        cin >> n;
    }
    return 0;
}
