#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int n, p;
    cin >> n >> p;
    int a[n];
    int solve = 0, penalty = 0, time = 0;
    for (int i = 0; i < n; i++) {
        if (i != p) {
            cin >> a[i];
        } else {
            solve++;
            cin >> penalty;
            time = penalty;
            a[i] = 1000;
        }
    }
    if (penalty > 300) {
        cout << 0 << " " << 0;
    } else {
        sort(a, a + n);
        int i = 0;
        while (i < n - 1 && time + a[i] <= 300) {
            solve++;
            time += a[i];
            penalty += time;
            i++;
        }
        cout << solve << " " << penalty;
    }
    return 0;
}
