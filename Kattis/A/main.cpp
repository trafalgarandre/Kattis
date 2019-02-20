#include <iostream>

using namespace std;

int main()
{
    int n;
    cin >> n;
    int a[n];
    int ma = 0;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
        if (a[i] > ma) {
            ma = a[i];
        }
    }
    int total = 0;
    int ma2 = 0;
    for (int i = 0; i < n; i++) {
        if (a[i] == ma) {
            total++;
        } else {
            if (total > ma2) {
                ma2 = total;
            }
            total = 0;
        }
    }
    if (total > ma2) {
        ma2 = total;
    }
    cout << ma2;
    return 0;
}
