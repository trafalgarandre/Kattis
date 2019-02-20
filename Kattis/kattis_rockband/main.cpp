#include <bits/stdc++.h>

using namespace std;

int main()
{
    int m, s;
    cin >> m >> s;
    int a[m][s];
    set<int> se;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < s; j++) {
            cin >> a[i][j];
        }
    }

    for (int i = 0; i < s; i++) {
        for (int j = 0; j < m; j++) {
            se.insert(a[j][i]);
        }
        if (se.size() == i + 1) {
            break;
        }
    }

    set<int>::iterator it = se.begin();
    cout << se.size() << '\n';
    while (it != se.end()) {
        cout << *it << ' ';
        it++;
    }
    return 0;
}
