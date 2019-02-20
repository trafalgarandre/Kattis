#include <iostream>
#include <algorithm>

using namespace std;

struct person {
    long long val;
    int t;
};

bool comp(person a, person b) {
    return a.val > b.val;
}

int main()
{
    int n, t;
    cin >> n >> t;
    person a[n];
    bool check[t + 1];
    for (int i = 0; i < t + 1; i++) {
        check[i] = false;
    }
    for (int i = 0; i < n; i++) {
        cin >> a[i].val >> a[i].t;
    }
    sort(a, a + n, comp);
    long long value = 0;
    int s = 0;
    for (int i = 0; i < n; i++) {
        int temp = a[i].t;
        while (check[temp]) {
            temp--;
        }
        if (temp >= 0) {
            check[temp] = true;
            value += a[i].val;
            s++;
        }
        if (s == t + 1) {
            break;
        }
    }
    cout << value;
    return 0;
}
