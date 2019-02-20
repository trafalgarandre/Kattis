#include <iostream>

using namespace std;

int main()
{
    int n;
    cin >> n;
    int c[n], a[n + 1][n + 1];
    for (int i = 0; i < n; i++) {
        cin >> c[i];
        if (i == 0) {
            a[1][0] += c[i];
        } else {
            a[1][i] = a[1][i - 1] + c[i];
        }
    }
    for (int i = 2; i <= n; i++) {
        for (int j = 1; j < i; j++) {
            a[i][j] = a[j][i - j - 1] + c[i];
        }
    }
    return 0;
}
