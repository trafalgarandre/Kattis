#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    long long n;
    cin >> n;
    int a[n];
    long long total = 0;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
        total += a[i];
    }
    sort(a, a + n);
    long long temp = total - a[n - 1];
    if (temp >= a[n - 1]) {
        cout << total;
    } else {
        cout << total + a[n - 1] - temp;
    }
    return 0;
}
