#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    int n, w;
    cin >> n;
    for (int j = 0; j < n; j++) {
        cin >> w;
        uint64_t a[w];
        for (int i = 0; i < w; i++) {
            cin >> a[i];
        }

        uint64_t t1 = a[0];
        int t2 = 1;
        bool soLarge = false;
        while (t2 < w) {
            t1 = (t1 * a[t2]) / __gcd(t1, a[t2]);
            if (t1 > 1000000000) {
                soLarge = true;
            }
            t2++;
        }
        if (soLarge) {
            cout << "More than a billion.\n";
        } else {
            cout << t1 << '\n';
        }
    }
    return 0;
}
