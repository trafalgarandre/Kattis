#include <bits/stdc++.h>

using namespace std;

struct node {
    int j, w;
};

bool cmp(node a, node b) {
    return a.j < b.j;
}

int main()
{
    int n;
    cin >> n;
    while (n != 0) {
        vector<vector<node>> vv;
        for (int i = 0; i < n; i++) {
            vv.push_back({});
        }
        for (int i = 0; i < n; i++) {
            int k;
            cin >> k;
            for (int j = 0; j < k; j++) {
                node temp;
                int jj;
                cin >> jj >> temp.w;
                temp.j = i;
                vv[jj].push_back(temp);
            }
        }
        cout << n << '\n';
        for (int i = 0; i < n; i++) {
            cout << vv[i].size();
            sort(vv[i].begin(), vv[i].end(), cmp);
            for (node no: vv[i]) {
                cout << " " << no.j << " " << no.w;
            }
            cout << '\n';
        }
        cin >> n;
    }
    return 0;
}
