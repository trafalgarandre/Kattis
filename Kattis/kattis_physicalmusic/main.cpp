#include <bits/stdc++.h>

using namespace std;

int main()
{
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> res = {};
        bool b[n + 1] = {false};
        int l = 1;
        for (int i = 0; i < n; i++) {
            int temp;
            cin >> temp;
            if (temp == l) {
                l++;
                while (l <= n && b[l]) {
                    l++;
                }
            } else {
                res.push_back(temp);
                b[temp] = true;
            }
        }
        sort(res.begin(), res.end());
        cout << res.size() << '\n';
        for (int i = 0; i < res.size(); i++) {
            cout << res[i] << '\n';
        }
    }
    return 0;
}
