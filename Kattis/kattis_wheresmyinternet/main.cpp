#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct Node {
    int index;
    vector<int> connected;
};

typedef long long l;

int main()
{
    l n, m;
    cin >> n >> m;
    Node nodes[n];
    bool check[n];
    for (l i = 0; i < n; i++) {
        check[i] = false;
        nodes[i].index = i;
    }
    check[0] = true;
    for (l i = 0; i < m; i++) {
        l a,b;
        cin >> a >> b;
        nodes[a - 1].connected.push_back(b - 1);
        nodes[b - 1].connected.push_back(a - 1);
    }

    queue<Node> q;
    q.push(nodes[0]);
    while (!q.empty()) {
        Node cur = q.front();
        q.pop();
        for (int node: cur.connected) {
            if (!check[node]) {
                q.push(nodes[node]);
                check[node] = true;
            }
        }
    }
    bool isConnected = true;
    for (l i = 0; i < n; i++) {
        if (!check[i]) {
            isConnected = false;
            cout << (i + 1) << '\n';
        }
    }
    if (isConnected) {
        cout << "Connected\n";
    }
    return 0;
}
