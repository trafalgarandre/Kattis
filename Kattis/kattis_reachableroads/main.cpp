#include <iostream>
#include <vector>
#include <queue>

using namespace std;

typedef vector<int> vi;
typedef vector<vi> vii;

int main()
{
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n;
        vii adj(n);
        bool c[n];
        fill_n(c, n, false);
        cin >> m;
        while (m--) {
            int a,b;
            cin >> a >> b;
            adj[a].push_back(b);
            adj[b].push_back(a);
        }
        queue<int> q;
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (!c[i]) {
                num++;
                c[i] = true;
                q.push(i);
                while (!q.empty()) {
                    int cur = q.front();
                    q.pop();
                    for (int j: adj[cur]) {
                        if (!c[j]) {
                            c[j] = true;
                            q.push(j);
                        }
                    }
                }
            }
        }
        cout << num - 1 << '\n';
    }
    return 0;
}
