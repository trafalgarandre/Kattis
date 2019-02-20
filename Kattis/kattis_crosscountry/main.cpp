#include <iostream>
#include <vector>
using namespace std;

struct Node {
    int index;
    long long weight = 0;
};

int main()
{
    int n, s, t;
    cin >> n >> s >> t;
    int a[n][n];
    Node nodes[n];
    bool check[n];
    for (int i = 0; i < n; i++) {
        nodes[i].index = i;
        check[i] = false;
        for (int j = 0; j < n; j++) {
            cin >> a[i][j];
        }
    }

    vector<Node*> q;
    for (int i = 0; i < n; i++) {
        if (i != s) {
            q.push_back(&nodes[i]);
            nodes[i].weight = a[s][i];
        }
    }
    check[s] = true;
    while (!q.empty()) {
        int min_weight = q.at(0)->weight;
        int min_index = 0;
        for (int i = 1; i < q.size(); i++) {
            if (q.at(i)->weight < min_weight) {
                min_weight = q.at(i)->weight;
                min_index = i;
            }
        }
        Node cur = *q[min_index];
        q.erase(q.begin() + min_index);
        check[cur.index] = true;
        for (int i = 0; i < n; i++) {
            if (!check[i] && i != cur.index && nodes[i].weight > cur.weight + a[cur.index][nodes[i].index]) {
                nodes[i].weight = cur.weight + a[cur.index][nodes[i].index];
            }
        }
    }
    cout << nodes[t].weight;
    return 0;
}
