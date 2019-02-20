#include <iostream>
#include <algorithm>

using namespace std;

bool comp(int a, int b) {
    return a > b;
}

int main()
{
    long long n;
    cin >> n;
    long long a[n];
    for (long long i = 0; i < n; i++) {
        cin >> a[i];
    }
    sort(a, a + n, comp);
    long long pos = 0;
    long long discount = 0;
    while (pos < n - 2) {
        discount += a[pos + 2];
        pos +=3;
    }
    cout << discount;
    return 0;
}
