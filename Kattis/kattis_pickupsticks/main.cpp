#include <bits/stdc++.h>

using namespace std;

struct node {
    int id;
    int left = 0;
    vector<int> child;
    bool operator < (const node &other) const {
        if (left == other.left) {
            return id < other.id;
        } else {
        return left < other.left; }
    }
};

int main()
{
    int n, m;
    cin >> n >> m;
    node nodes[n];
    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        a--;
        b--;
        nodes[a].child.push_back(b);
        nodes[b].left++;
    }

    set<node> s;

    for (int i = 0; i < n; i++) {
        nodes[i].id = i;
        s.insert(nodes[i]);
    }

    vector<int> a;
    bool fail = false;
    while (!s.empty()) {
        node cur = *s.begin();
        if (cur.left == 0) {
            a.push_back(cur.id + 1);
        } else {
            fail = true;
            break;
        }
        s.erase(cur);
        for (int i: cur.child) {
            s.erase(nodes[i]);
            nodes[i].left--;
            s.insert(nodes[i]);
        }
    }
    if (fail) {
        cout << "IMPOSSIBLE\n";
    } else {
        for (int i: a)
        cout << i << '\n';
    }

    return 0;
}
