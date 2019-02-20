#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n;
    cin >> n;
    vector<char> cs(n), gs(n);
    for (int i = 0; i < n; i++) {
        cin >> cs[i];
    }

    for (int i = 0; i < n; i++) {
        cin >> gs[i];
    }
    int r,s;
    r = s = 0;
    for (int i = 0; i < n; i++) {
        if (cs[i] == gs[i]) {
            r++;
            cs[i] = 'a';
            gs[i] = 'a';
        }
    }

    for (int i = 0; i < n; i++) {
        if (cs[i] != 'a') {
            for (int j = 0; j < n; j++) {
                if (cs[i] == gs[j]) {
                    gs[j] = 'a';
                    cs[i] = 'a';
                    s++;
                    break;
                }
            }
        }
    }
    cout << r << ' ' << s << '\n';
    return 0;
}
