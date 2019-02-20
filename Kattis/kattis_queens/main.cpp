#include <iostream>

using namespace std;

int main()
{
    int n;
    cin >> n;
    bool col[n] = {false};
    bool row[n] = {false};
    bool sub[n * 2] = {false};
    bool sum[n * 2] = {false};
    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;
        if (col[x] || row[y] || sub[n + x - y] || sum[x + y]) {
            cout << "INCORRECT";
            return 0;
        }
        col[x] = true;
        row[y] = true;
        sub[n + x - y] = true;
        sum[x + y] = true;
    }

    cout << "CORRECT";
    return 0;
}
