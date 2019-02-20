#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int t;
    cin >> t;
    for (int i = 0; i < t; i++) {
        int n;
        cin >> n;
        long long v1[n], v2[n];
        for (int j = 0; j < n; j++) {
            cin >> v1[j];
        }
        for (int j = 0; j < n; j++) {
            cin >> v2[j];
        }
        sort(v1, v1 + n);
        sort(v2, v2 + n);
        long long total = 0;
        for (int j = 0; j < n; j++) {
            total = total + (v1[j] * v2[n - j - 1]);
        }
        cout << "Case #" << i + 1 << ": " << total << endl;
    }
    return 0;
}

