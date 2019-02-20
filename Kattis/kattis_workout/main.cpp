#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

struct m {
    ll u, r, t;
};

int main()
{
    vector<pair<ll, ll>> base;
    vector<m> other(10);
    for (int i = 0; i < 10; i++) {
        ll t1, t2;
        cin >> t1 >> t2;
        base.push_back(make_pair(t1, t2));
    }
    for (int i = 0; i < 10; i++) {
        cin >> other[i].u >> other[i].r >> other[i].t;
    }

    long long t = 0;
    for (int i = 0; i < 3; i++) {
        int pos = 0;
        while (pos != 10) {
            if (t < other[pos].t) {
                t = t + base[pos].first + base[pos].second;
                other[pos].t = max (other[pos].t, t - base[pos].second);
            } else {
                while (t >= other[pos].t + other[pos].u + other[pos].r) {
                    other[pos].t = other[pos].t + other[pos].u + other[pos].r;
                }
                if (t < other[pos].t + other[pos].u) {
                    t = other[pos].t + other[pos].u + base[pos].first + base[pos].second;
                    other[pos].t = max(other[pos].t + other[pos].u + other[pos].r, t - base[pos].second);
                } else {
                    t = t + base[pos].first + base[pos].second;
                    other[pos].t = max(other[pos].t + other[pos].u + other[pos].r, t - base[pos].second);
                }
            }
            pos++;
        }
    }
    cout << t - base[9].second;
    return 0;
}
