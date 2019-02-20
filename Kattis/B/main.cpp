#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int main()
{
    ll n, m, k;
    cin >> n >> m >> k;
    ll a[n];
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    sort(a, a + n);
    ll big = a[n - 1];
    ll second = a[n - 2];
    ll temp = m / (k + 1);
    ll total = (big * k + second) * temp;
    ll rest = m % (k + 1);
    total = total + rest * big;
    cout << total;
    return 0;
}
