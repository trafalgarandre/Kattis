#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    int n, m;
    cin >> n >> m;
    while (n != 0 || m != 0) {
        int d[n], k[m];
        for (int i = 0; i < n; i++) {
            cin >> d[i];
        }
        for (int i = 0; i < m; i++) {
            cin >> k[i];
        }
        sort (d, d + n);
        sort (k, k + m);
        int td = 0;
        int tk = 0;
        int total = 0;
        while (td != n && tk != m) {
            if (d[td] <= k[tk]) {
                td++;
                total += k[tk];
            }
            tk++;
        }
        if (td != n) {
            cout << "Loowater is doomed!\n";
        } else {
            cout << total << '\n';
        }
        cin >> n >> m;
    }
    return 0;
}
