#include <bits/stdc++.h>

using namespace std;

#define LSOne(S) ((S) & -(S))

typedef vector<int> vi;

class FenwickTree {
    private: vi ft; int n;
    public: FenwickTree(int _n) : n(_n) {
        ft.assign(n + 1, 0);
    }

    int rsq(int j) {
        int sum = 0;
        for (; j; j -= LSOne(j)) sum += ft[j];
        return sum;
    }

    int rsq(int i, int j) {
        if (i > n || j > n || i * j == 0) {
            return 0;
        }
        return rsq(j) - rsq(i - 1);
    }

    void update(int i, int v) {
        for (; i <= n; i += LSOne(i)) ft[i] +=v;
    }
};

int main()
{
    int n;
    cin >> n;
    int a[n];
    long long b[n] = {0}, c[n] = {0};
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    long long result = 0;
    FenwickTree ft(n);
    for (int i = n - 1; i >= 0; i--) {
        ft.update(a[i], 1);
        b[i] += ft.rsq(1, a[i] - 1);
    }
    FenwickTree ft2(n);
    for (int i = 0; i < n; i++) {
        ft2.update(a[i], 1);
        c[i] += ft2.rsq(a[i] + 1, n);
    }

    for (int i = 0; i < n; i++) {
        result += b[i] * c[i];
    }

    cout << result;
    return 0;
}
