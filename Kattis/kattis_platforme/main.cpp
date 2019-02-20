#include <iostream>
#include <algorithm>

using namespace std;

struct Platform {
    int height;
    int left;
    int right;
};

bool comp(Platform a, Platform b) {
    return a.height < b.height;
}

int main()
{
    int n;
    cin >> n;
    Platform a[n];
    for (int i = 0; i < n; i++) {
        cin >> a[i].height >> a[i].left >> a[i].right;
    }
    sort(a, a + n, comp);
    long long total = 0;
    for (int i = 0; i < n; i++) {
        int h1 = a[i].height;
        int h2 = a[i].height;
        for (int j = i - 1; j >= 0; j--) {
            if (h1 == a[i].height && a[i].left >= a[j].left && a[i].left < a[j].right) {
                h1 -= a[j].height;
            }
            if (h2 == a[i].height && a[i].right > a[j].left && a[i].right <= a[j].right) {
                h2 -= a[j].height;
            }
        }
        total = total + h1 + h2;
    }
    cout << total;
    return 0;
}
